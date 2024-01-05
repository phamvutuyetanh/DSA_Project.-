class Mergesort extends Basesort{
    constructor(namebutton1, namebutton2, nameElement1, canvasId){
        super(namebutton1, namebutton2, nameElement1, canvasId);
        this.totalcompare = 0;
        this.totalcoppies = 0;
    }

    animate() {
        
        this.ctx.clearRect(0, 0, 1800, 1100);
        let changed = false;
        for(let i=0; i<this.cols.length; i++){
            changed = this.cols[i].draw(this.ctx)||changed;
        }
        if(!changed && this.moves.length > 0){
            var movee = this.moves.shift();
            var [i,j]= movee.indices;
            var n = movee.swapnumber;
            var nCompare = movee.ncompare;
            var total = movee.totalcomparison;
            if(movee.swapp){
                this.swapname.textContent = "Total of copies: ................. "+n+" ................................................. Numbers of compare in each merge sub :.......... "+ nCompare +" .................... Total comparision: ........."+ total + "........";
                this.cols[i].moveToTo(this.cols[j], -1);
                this.cols[j].moveToTo(this.cols[i]);

                [this.cols[i], this.cols[j]]= [this.cols[j], this.cols[i]]
            } else{
                this.swapname.textContent = "Total of copies: ................. "+n+" ................................................. Numbers of compare in each merge sub:.......... "+ nCompare +" .................... Total comparision: ........."+ total + "........";
                // this.cols[i].jump();
                // this.cols[j].jump();
            }
        }
        requestAnimationFrame(() => this.animate());
    }

    sortt(array){
        var moves_merge = [];
        var workSpace = [];
    
        this.totalcompare = 0;
        this.totalcoppies = 0;
        this.recMergeSort(moves_merge,array,workSpace, 0, array.length-1);

        return moves_merge;
    


}

 recMergeSort(moves_merge, array,workSpace, lowerBound, upperBound){
    if(lowerBound==upperBound){
        return;
    }
    else {
        var mid1 = Math.floor((lowerBound+upperBound)/2);
         this.recMergeSort(moves_merge,array,workSpace, lowerBound, mid1);
         this.recMergeSort(moves_merge,array,workSpace, mid1+1, upperBound);
         this.merge(moves_merge,array,workSpace, lowerBound,mid1+1, upperBound)
    }
}

 merge(moves_merge, array,workSpace, lowPtr, highPtr, upperBound){
    var array_coppy = array;
    var comparision_merge = 0;
    var j= 0;
    var lowerBound = lowPtr;
    var mid = highPtr -1;
    var n = upperBound -lowerBound+1;
    while(lowPtr <= mid && highPtr <= upperBound){
        // recordcompare.push(++compare)
        // recordcopy.push(++copy);
        comparision_merge++;
        this.totalcoppies++;
        if( array[lowPtr] < array[highPtr] ){
            workSpace[j++] = array[lowPtr++];
        }
         else{
            workSpace[j++] = array[highPtr++];
    
         }
    }
    while(lowPtr <= mid){
        // recordcopy.push(++copy);
        this.totalcoppies++;
        workSpace[j++] = array[lowPtr++];
    }
         

      while(highPtr <= upperBound){
        this.totalcoppies++;
        // recordcopy.push(++copy);
        workSpace[j++] = array[highPtr++];
      }
       this.totalcompare = this.totalcompare + comparision_merge;
      for(let j=0; j<n; j++){
        // recordcopy.push(++copy);
       if(array[lowerBound+j] == workSpace[j]){
        moves_merge.push({indices: [lowerBound+j, index], swapp: false ,swapnumber: this.totalcoppies++, ncompare:comparision_merge, totalcomparison: this.totalcompare });
       }
       else{
        var index = 0;
            for(let i = 0; i<array_coppy.length;i++){
                if(array_coppy[i] == workSpace[j]){
                    index = i;
                    break;
                }
            }
            moves_merge.push({indices: [lowerBound+j, index], swapp: true,swapnumber: this.totalcoppies++,  ncompare:comparision_merge, totalcomparison: this.totalcompare});
            [array_coppy[lowerBound+j], array_coppy[index]] = [array_coppy[index], array_coppy[lowerBound+j]]; 
      }
      
      array[lowerBound+j] = workSpace[j];
}
    
}
}

