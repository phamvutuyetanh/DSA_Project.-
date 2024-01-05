class Selectionsort extends Basesort{
    constructor(namebutton1, namebutton2, nameElement1, canvasId){
        super(namebutton1, namebutton2, nameElement1, canvasId);
        this.swapselect = 0;
        this.compare = 0;
    }
    sortt(array){
        var moves_select = [];
        // i = out 
        for (let i = 0; i < array.length - 1; i++) {
            let minIndex = i;
    //j = in
            for (let j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
    
                moves_select.push({ indices: [i, j], swapp: false,  swapnumber: this.swapselect, ncompare: ++ this.compare });
            }
            //console.log(array_selection[minIndex]);
    
            if (minIndex !== i) {
                [array[i], array[minIndex]] = [array[minIndex], array[i]];
                moves_select.push({ indices: [i, minIndex], swapp: true,  swapnumber: ++this.swapselect, ncompare: this.compare});
            } 
            else {
                moves_select.push({ indices: [i, minIndex], swapp: false,  swapnumber: this.swapselect, ncompare: this.compare });
            }
        }
        this.swapselect = 0;
        this.compare = 0;
        return moves_select;
}
}