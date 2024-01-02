class Basesort {
    constructor(namebutton1, namebutton2, nameElement1){
        this.nElems = 10;
        this.magrin = 10;
        this.array = [];
        this.moves = [];
        this.maxheight = 8;
        this.cols = [];
        this.namebutton1 = namebutton1; // button select nElems
        this.namebutton2 = namebutton2; // button select speed
        this.swapname = document.getElementById(nameElement1);
        this.mycanvaswidth = 1800;
        this.mycanvasheight = 1100
        this.speed = 500;
        this.cop = [];

    }

    create(){
            
        this.cols = [];
        this.array = []; 
        var selectElement = document.querySelector(this.namebutton1);
        this.nElems = selectElement.value;

        var selectspeed = document.querySelector(this.namebutton2);
         this.speed = selectspeed.value;

        if(this.nElems == 10){
            this.array = [7,21,30,39,48,57,66,72,81,87];
            // this.cop = [64,21,33,70,12,85,44,3,97,24];
        }
        else if(this.nElems == 20){
            this.array = [3,9,15,21,27,30,36,42,48,51,57,60,66,69,72,75,78,81,84,87,90];
            // this.cop = [64,21,33,70,12,85,44,3,97,24, 6, 10, 18, 25, 37, 80, 55, 71, 67];
        }
        else {
            this.array = [3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60,63,66,69,72,75,78,81,84,87,90];
        }
        this.array = this.shuffle(this.array);
        this.cop = [...this.array];
        var spacing = (300 - this.magrin*2)/this.nElems;
        this.moves=[];
        for(let i=0; i<this.array.length; i++){
            const x = (i*spacing+spacing/2 + this.magrin*8)*4;
            const y = this.mycanvasheight - (this.magrin*7) - i *5;
            var width1 = 0;
            if(this.nElems == 10){
                 width1 = (spacing-7)*4.5;
            }
            else if (this.nElems == 20){
                width1 = (spacing-4)*4.5;
            }
           else{
                width1 = (spacing- 3)*4.5;
           }
            const width = width1;
            const height = this.maxheight*this.array[i];
            this.cols[i] = new Column(x, y, width, height,this.speed);     
        }   
    }
    createagain(){
        this.cols = [];
        this.array = [...this.cop];
        var selectspeed = document.querySelector(this.namebutton2);
         this.speed = selectspeed.value;
        var spacing = (300 - this.magrin*2)/this.nElems;
        this.moves=[];
        for(let i=0; i<this.array.length; i++){
            const x = (i*spacing+spacing/2 + this.magrin*8)*4;
            const y = this.mycanvasheight - (this.magrin*7) - i *5;
            var width1 = 0;
            if(this.nElems == 10){
                 width1 = (spacing-7)*4.5;
            }
            else if (this.nElems == 20){
                width1 = (spacing-4)*4.5;
            }
           else{
                width1 = (spacing- 3)*4.5;
           }
            const width = width1;
            const height = this.maxheight*this.array[i];
            this.cols[i] = new Column(x, y, width, height,this.speed);     
        }   
    }

    shuffle(array) {
        let currentIndex = array.length,  randomIndex;
      
        // While there remain elements to shuffle.
        while (currentIndex > 0) {
      
          // Pick a remaining element.
          randomIndex = Math.floor(Math.random() * currentIndex);
          currentIndex--;
      
          // And swap it with the current element.
          [array[currentIndex], array[randomIndex]] = [
            array[randomIndex], array[currentIndex]];
        }
      
        return array;
      }

    animate(ctx) {
        ctx.clearRect(0, 0, 1800, 1100);
        let changed = false;
        for(let i=0; i<this.cols.length; i++){
            changed = this.cols[i].draw(ctx)||changed;
        }
        if(!changed && this.moves.length > 0){
            var movee = this.moves.shift();
            var [i,j]= movee.indices;
            var n = movee.swapnumber;
            var nCompare = movee.ncompare;
            if(movee.swapp){
                this.swapname.textContent = "Numbers of swap:........ "+n+" ....... Numbers of compare:........ "+ nCompare+" ........";
                this.cols[i].moveTo(this.cols[j]);
                this.cols[j].moveTo(this.cols[i], -1);

                [this.cols[i], this.cols[j]]= [this.cols[j], this.cols[i]]
            } else{
                this.swapname.textContent = "Numbers of swap:........ "+n+" ....... Numbers of compare:........ "+ nCompare+" ........";
                this.cols[i].jump();
                this.cols[j].jump();
            }
        }
        requestAnimationFrame(() => this.animate(ctx));
    }

    sort(){
    var selectElement = document.querySelector(this.namebutton1);
    var selectvalue = selectElement.value;
    if(selectvalue != this.nElems){
        this.create();
    }
        this.createagain();
        this.moves=this.sortt(this.array);
        
    }

    sortt(array){
    console.log("HE");
      
    }
    

    


}