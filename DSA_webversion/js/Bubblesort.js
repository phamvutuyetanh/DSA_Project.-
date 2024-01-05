class Bubblesort extends Basesort{
    constructor(namebutton1, namebutton2, nameElement1, canvasId){
        super(namebutton1, namebutton2, nameElement1, canvasId);
    }
    sortt(array){
        let moves = [];
        let out;
        let int;
        let swapbubble = 0;
        let compare = 0;
      for (out = array.length - 1; out >= 1; out--){
        for (int = 0; int < out; int++) {
            // inner loop (forward)
        if (array[int] > array[int + 1]){
            [array[int], array[int+1]] = [array[int+1], array[int]];
            moves.push(
    
                {indices: [int,int+1], swapp: true, swapnumber: ++swapbubble, ncompare: ++ compare}
            )
        }
        else{
            moves.push(
    
                {indices: [int,int+1], swapp: false, swapnumber: swapbubble, ncompare: ++compare}
            )
        }
        
        }
      } // outer loop (backward)
      return moves;
    }
}