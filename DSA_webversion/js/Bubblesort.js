class Bubblesort extends Basesort{
    constructor(namebutton1, namebutton2, nameElement1){
        super(namebutton1, namebutton2, nameElement1);
        this.swapbubble = 0;
        this.compare = 0;
    }
    sortt(array){
        var moves = [];
        var out;
        var int;

      for (out = array.length - 1; out >= 1; out--){
        for (int = 0; int < out; int++) {
            // inner loop (forward)
        if (array[int] > array[int + 1]){
            [array[int], array[int+1]] = [array[int+1], array[int]];
            moves.push(
    
                {indices: [int,int+1], swapp: true, swapnumber: ++this.swapbubble, ncompare: ++ this.compare}
            )
        }
        else{
            moves.push(
    
                {indices: [int,int+1], swapp: false, swapnumber: this.swapbubble, ncompare: ++this.compare}
            )
        }
        
        }
      } // outer loop (backward)
      this.swapbubble = 0;
      this.compare = 0; 
      return moves;
    }
}