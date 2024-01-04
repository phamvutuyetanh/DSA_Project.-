

 const canvasS = new Canvas('myCanvasSelection');
 const selection = new Selectionsort("#select2A","#select2B", "Big0Select");
 function sortS(){
   canvasS.sort();
 }
 function createS(){
    selection.create();
  }
 canvasS.addElement(selection);
canvasS.draw(); 
selection.create();

//Insertion

const canvasI = new Canvas('myCanvasInsertion');
const insertion = new Insertionsort("#select3A","#select3B", "Big0Insert");
function sortI(){
  canvasI.sort();
}
function createI(){
    insertion.create();
  }
canvasI.addElement(insertion);
canvasI.draw(); 
insertion.create();


// Quick Sort  
const canvasQ = new Canvas('myCanvasQuick');
const quick = new QuickSort("#select4A", "#select4B","Big0Quick");
function sortQ(){
  canvasQ.sort();
}
function createQ(){
    quick.create();
  }
canvasQ.addElement(quick);
canvasQ.draw(); 
quick.create();

// Shell Sort
const canvasShell = new Canvas('myCanvasShell');
const shell = new Shellsort("#select6A","#select6B", "Big0Shell");
function sortShell(){
  canvasShell.sort();
}
function createShell(){
    shell.create();
  }
canvasShell.addElement(shell);
canvasShell.draw(); 
shell.create();
// Bubble Sort
const canvasB = new Canvas('Canvas');
  const bubblesort = new Bubblesort("#select1A","#select1B","Big0Bubble" );

  function sortB(){
    canvasB.sort();
  }
  function createB(){
    bubblesort.create();
  }
  canvasB.addElement(bubblesort);
//   canvas.create();
canvasB.draw(); 
 bubblesort.create();


// Merge sort   myCanvasMerge
const canvasM = new Canvas('myCanvasMerge');
const merge = new Mergesort("#select5A","#select5B", "Big0Merge");
function sortM(){
  canvasM.sort();
}
function createM(){
    merge.create();
  }
canvasM.addElement(merge);
canvasM.draw(); 
merge.create();
