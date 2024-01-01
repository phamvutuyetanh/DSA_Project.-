class Canvas {
    constructor(canvasId) {
      this.canvas = document.getElementById(canvasId);
      this.context = this.canvas.getContext('2d');
      this.elements = [];
    }
  
    addElement(element) {
      this.elements.push(element);
    }
    clearCanvas() {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
      }

  create(){
    this.elements.forEach(element => {
        element.create();
      });
  }
    draw() {
       
      this.elements.forEach(element => {
        element.animate(this.context);
      });
    }

    sort(){
        this.elements.forEach(element => {
            this.draw();
          element.sort();
        });
        
    }
  }