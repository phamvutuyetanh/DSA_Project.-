

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

// const canvasI = new Canvas('myCanvasInsertion');
// const insertion = new Insertionsort("#select3A","#select3B", "Big0Insert");
// function sortI(){
//   canvasI.sort();
// }
// function createI(){
//     insertion.create();
//   }
// canvasI.addElement(insertion);
// canvasI.draw(); 
// insertion.create();


// Quick Sort  
// const canvasQ = new Canvas('myCanvasQuick');
// const quick = new QuickSort("#select4A", "#select4B","Big0Quick");
// function sortQ(){
//   canvasQ.sort();
// }
// function createQ(){
//     quick.create();
//   }
// canvasQ.addElement(quick);
// canvasQ.draw(); 
// quick.create();


// Merge sort   myCanvasMerge
// const canvasM = new Canvas('myCanvasMerge');
// const merge = new Mergesort("#select5A","#select5B", "Big0Merge");
// function sortM(){
//   canvasM.sort();
// }
// function createM(){
//     merge.create();
//   }
// canvasM.addElement(merge);
// canvasM.draw(); 
// merge.create();
