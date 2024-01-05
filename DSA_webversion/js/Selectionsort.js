class Selectionsort extends Basesort{
    constructor(namebutton1, namebutton2, nameElement1, canvasId){
        super(namebutton1, namebutton2, nameElement1, canvasId);
        
    }
    sortt(array){
        let moves_select = [];
        let swapselect = 0;
        let compare = 0;
        for (let i = 0; i < array.length - 1; i++) {
            let minIndex = i;
    //j = in
            for (let j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
    
                moves_select.push({ indices: [i, j], swapp: false,  swapnumber: swapselect, ncompare: ++ compare });
            }
    
            if (minIndex !== i) {
                [array[i], array[minIndex]] = [array[minIndex], array[i]];
                moves_select.push({ indices: [i, minIndex], swapp: true,  swapnumber: ++swapselect, ncompare: compare});
            } 
            else {
                moves_select.push({ indices: [i, minIndex], swapp: false,  swapnumber: swapselect, ncompare: compare });
            }
        }
        return moves_select;
}
}