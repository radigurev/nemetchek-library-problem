
var table=document.getElementById('table');
var books=document.getElementById('add-books');
var button=document.getElementById('edit-button');
var tb = [...table.childNodes[3].childNodes[1].childNodes[1].childNodes].reverse();
var time=300;

function sorted() {
    tb.forEach((c,i) =>{
        c.style='transition: opacity 0.9s ease';
    }
    );
   tb.forEach((c,i) => {
        if(i%2!=0)
        setTimeout(function() {
            c.style.opacity=0;
        },time);
        time+=100;
    });
}

function tableClick() {
    if(button.classList.contains('fa-pen'))
    toEdit();
    else 
        toTable();
}

function toEdit() {
    books.style.left='50%';
    table.style.left='-150%';
    button.classList.remove('fa-pen');
    button.classList.add('fa-table');
}

function toTable() {
    books.style.left='150%';
    table.style.left='50%';
    button.classList.add('fa-pen');
    button.classList.remove('fa-table');
}