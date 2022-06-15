
var books=document.getElementById('add-books');
var button=document.getElementById('edit-button');
var time=300;
var headers= [...document.getElementsByClassName('header')];
var icons = [...document.getElementsByClassName('icon')];

var active=null;
var specialTitle=null;

if(document.getElementById("is-window-open")!=null) {
    tableClick();
}

function sort() {
    sortTable(0);
headers.forEach((h,i) => {
    h.addEventListener('click', function() {
        sortTable(i);
    });
});
};

function sortTable(inx) {
    var sortAsc=true;
    if(active!=null && active!=icons[inx]) {
        active.classList.remove('fa-sort-up');
        active.classList.remove('fa-sort-down');
    }

    if(icons[inx].classList.contains('fa-sort-up')) {
        icons[inx].classList.remove('fa-sort-up')
        icons[inx].classList.add('fa-sort-down');
        sortAsc=false;
    }else {
    icons[inx].classList.add('fa-sort-up');
    }
    
    active=icons[inx];

    tb=[...document.getElementById('myTable').rows].reverse();

    for(let c of tb){
        c.style='transition: opacity 0.5s ease';
    };

    for(let c of tb) {
        setTimeout(function() {
            c.style.opacity=0;
        },time);
        time+=30;
    };


    setTimeout(function() {
        var table, rows, switching, i, x, y, shouldSwitch;
        table = document.getElementById("myTable");
        switching = true;
        while (switching) {
          switching = false;
          rows = table.rows;

          for(let r of rows) {
            if(r.childNodes[3].textContent=='Да убиеш присмехулник') {
                specialTitle=r;
            }
          }

          for (i = 0; i < (rows.length - 1); i++) {
            shouldSwitch = false;


            x = rows[i].getElementsByTagName("TD")[inx+1];
            y = rows[i + 1].getElementsByTagName("TD")[inx+1];
           if(sortAsc) {
            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                shouldSwitch = true;
                break;
              }
           }else {
            if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                shouldSwitch = true;
                break;
              }
           }
          }
          if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
          }
        }
        rows=table.rows;
        if(specialTitle!=null) {
            specialTitle.parentNode.insertBefore(specialTitle,rows[0]);
        }

        for(let i=0;i<rows.length;i++) {
            rows[i].childNodes[1].textContent=i+1;
        }

        for(let row of table.rows) {
            setTimeout(function() {
                row.style.opacity=1;
            },time);
            time+=50;
        }
    }, 300*tb.length);

    
  
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