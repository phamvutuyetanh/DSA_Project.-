class Insertionsort extends Basesort{
    constructor(namebutton1, namebutton2, nameElement1, canvasId){
        super(namebutton1, namebutton2, nameElement1, canvasId);
    }
    sortt(array){
        let moves_insert = [];
        let swapinsert = 0; // reset
        let compare = 0; //reset
    for(let i = 1; i <array.length; i++){
        let currentIndex = i;
        compare++;
        while (currentIndex >0 && array[currentIndex -1]> array[currentIndex]){
            [array[currentIndex-1], array[currentIndex]] = [array[currentIndex], array[currentIndex-1]]
            moves_insert.push({indices: [currentIndex -1, currentIndex], swapp: true,swapnumber: ++swapinsert, ncompare: ++ compare});
            currentIndex --;
        }
        if(currentIndex > 0){
            moves_insert.push({indices: [currentIndex-1, currentIndex], swapp: false, swapnumber: swapinsert, ncompare: compare}); 
        }
    }
    return moves_insert;
}
}