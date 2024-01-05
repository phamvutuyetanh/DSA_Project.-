
const selection = new Selectionsort("#select2A","#select2B", "Big0Select","myCanvasSelection" );
const insertion = new Insertionsort("#select3A","#select3B", "Big0Insert", "myCanvasInsertion");
const quick = new QuickSort("#select4A", "#select4B","Big0Quick", "myCanvasQuick");
const shell = new Shellsort("#select6A","#select6B", "Big0Shell", "myCanvasShell");
const bubblesort = new Bubblesort("#select1A","#select1B","Big0Bubble","Canvas" );
const merge = new Mergesort("#select5A","#select5B", "Big0Merge", "myCanvasMerge");
const sortArray = [bubblesort, selection, insertion, quick, merge, shell];
  for(let i = 0; i < sortArray.length; i++){  
    sortArray[i].create();
    sortArray[i].animate();
  }

  function create(button){
    var id = button.id;
    if(id === "bubblesort"){
      sortArray[0].create();
    }
    else if (id === "selectionsort"){ 
      sortArray[1].create();
    }
    else if (id === "insertionsort"){
      sortArray[2].create();
    }
    else if (id ==="quicksort"){
      sortArray[3].create();
    }
    else if (id === "mergesort"){
      sortArray[4].create();
    }
    else if (id === "shellsort"){
      sortArray[5].create();
    }
  }

  function sort(button){
    var id = button.id;
    if(id === "bubblesort"){
      sortArray[0].sort();
    }
    else if (id === "selectionsort"){ 
      sortArray[1].sort();
    }
    else if (id === "insertionsort"){
      sortArray[2].sort();
    }
    else if (id ==="quicksort"){
      sortArray[3].sort();
    }
    else if (id === "mergesort"){
      sortArray[4].sort();
    }
    else if (id === "shellsort"){
      sortArray[5].sort();
    }
  }
