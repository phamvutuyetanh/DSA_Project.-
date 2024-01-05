

const selection = new Selectionsort("#select2A","#select2B", "Big0Select","myCanvasSelection" );
function sortS(){
  selection.sort();
}
function createS(){
   selection.create();
 }
selection.animate();
selection.create();

//Insertion

const insertion = new Insertionsort("#select3A","#select3B", "Big0Insert", "myCanvasInsertion");
function sortI(){
  insertion.sort();
}
function createI(){
    insertion.create();
  }

insertion.animate(); 
insertion.create();


// Quick Sort  
const quick = new QuickSort("#select4A", "#select4B","Big0Quick", "myCanvasQuick");
function sortQ(){
  quick.sort();
}
function createQ(){
    quick.create();
  }
quick.animate();
quick.create();

// Shell Sort
const shell = new Shellsort("#select6A","#select6B", "Big0Shell", "myCanvasShell");
function sortShell(){
  shell.sort();
}
function createShell(){
    shell.create();
  }
shell.animate();
shell.create();
// Bubble Sort
  const bubblesort = new Bubblesort("#select1A","#select1B","Big0Bubble","Canvas" );

  function sortB(){
    bubblesort.sort();
  }
  function createB(){
    bubblesort.create();
  }
  bubblesort.animate(); 
 bubblesort.create();


// Merge sort   myCanvasMerge
const merge = new Mergesort("#select5A","#select5B", "Big0Merge", "myCanvasMerge");
function sortM(){
  merge.sort();
}
function createM(){
    merge.create();
  }
merge.animate();  
merge.create();
