class QuickSort extends Basesort{
    constructor(namebutton1, namebutton2, nameElement1, canvasId){
        super(namebutton1, namebutton2, nameElement1, canvasId);
        this.swap = 0;
       
        this.totalcomparison=0;
    }
    sortt(array){
        var moves_Q= [];
        this.swap = 0;
        this.totalcomparison=0;
        this.quickSortre(moves_Q,array,0,array.length-1);
        return moves_Q;
    }

    quickSortre(moves_Q,array,low, high) {
        if (low < high) {
            let pivot = this.partition(moves_Q,array,low, high);
            this.quickSortre(moves_Q,array,low, pivot - 1);
            this.quickSortre(moves_Q,array,pivot, high);
        }
    }

    partition(moves_Q,array,low, high) {
        var comparision = 0;
        let pivotIndex = Math.floor((low + high) / 2);
        let pivotValue = array[pivotIndex];
        let i = low;
        let j = high;
    
        while (i <= j) {
            while (array[i] < pivotValue) {
                comparision++;
                this.totalcomparison++;
                // this.totalcomparison++;
                i++;
            }
    
            while (array[j] > pivotValue) {
                comparision ++;
                this.totalcomparison++;
                // this.totalcomparison++;
                j--;
            }
            
            if (i <= j) {
                // Swap elements at indices i and j
                [array[i], array[j]] = [array[j], array[i]];

                moves_Q.push({ indices: [i, j], swapp: true,  swapnumber: ++this.swap, ncompare: comparision, totalcompare: this.totalcomparison });
                console.log("Hee");
                i++;
                j--;
            }
            else{
                moves_Q.push({ indices: [i, j], swapp: false,  swapnumber: this.swap, ncompare: comparision, totalcompare: this.totalcomparison });
            }
        }
        
    
        return i;
    }

    animate() {
        this.ctx.clearRect(0, 0, 1800, 1100);
        let changed = false;
        for(let i=0; i<this.cols.length; i++){
            changed = this.cols[i].draw(this.ctx)||changed;
        }
        if(!changed && this.moves.length > 0){
            console.log("Hi");
            var movee = this.moves.shift();
            var [i,j]= movee.indices;
            var n = movee.swapnumber;
            var nCompare = movee.ncompare;
            var total = this.totalcomparison;
            if(movee.swapp){
                this.swapname.textContent = "Numbers of swap:.... "+n+" ..... Number of comparison after each parition:.... "+ nCompare+" .... Total comparisions:...."+total+".....";
                this.cols[i].moveToTo(this.cols[j]);
                this.cols[j].moveToTo(this.cols[i], -1);

                [this.cols[i], this.cols[j]]= [this.cols[j], this.cols[i]]
            } else{
                this.swapname.textContent = "Numbers of swap:.... "+n+" ..... Numbers of comparíion after each parition:...."+ nCompare+" .... Total comparisions:...."+total+".....";
                this.cols[i].jump();
                this.cols[j].jump();
            }
        }
        requestAnimationFrame(() => this.animate());
    }
}