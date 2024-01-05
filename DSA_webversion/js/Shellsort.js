class Shellsort extends Basesort{
    constructor(namebutton1, namebutton2, nameElement1, canvasId){
        super(namebutton1, namebutton2, nameElement1, canvasId);
        // this.swap = 0;
        // this.compare = 0;
        
    }
    sortt(array){
        var moves = [];
        let n = array.length; 
        var swap = 0;
        var compare = 0;
        // Start with a big gap, then reduce the gap 
        for (let gap = Math.floor(n/2); gap > 0; gap = Math.floor(gap/2)) 
        { 
            for (let i = gap; i < n; i += 1) 
            { 
                console.log("before: "+ array); 
                let temp = array[i]; 
                let j;
                compare++;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap]; 
                    moves.push({indices: [j-gap, j], swapp: true, swapnumber: ++swap, ncompare: ++compare})
                } 
                array[j] = temp; 
                console.log("after: "+ array);
                moves.push({indices: [j,i], swapp: false, swapnumber: swap, ncompare: compare});
            } 
        } 
        return moves;
    }
}