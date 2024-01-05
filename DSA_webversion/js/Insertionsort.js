class Insertionsort extends Basesort{
    constructor(namebutton1, namebutton2, nameElement1, canvasId){
        super(namebutton1, namebutton2, nameElement1, canvasId);
        this.swapinsert = 0;
        this.compare = 0;
    }
    sortt(array){
        var moves_insert = [];

    for(let i = 1; i <array.length; i++){
        let currentIndex = i;
        this.compare++;
        while (currentIndex >0 && array[currentIndex -1]> array[currentIndex]){
            [array[currentIndex-1], array[currentIndex]] = [array[currentIndex], array[currentIndex-1]]
            moves_insert.push({indices: [currentIndex -1, currentIndex], swapp: true,swapnumber: ++this.swapinsert, ncompare: ++ this.compare});
            currentIndex --;
        }
        if(currentIndex > 0){
            moves_insert.push({indices: [currentIndex-1, currentIndex], swapp: false, swapnumber: this.swapinsert, ncompare: this.compare}); 
        }
    }
    this.swapinsert = 0;
    this.compare = 0;
    return moves_insert;
}
}