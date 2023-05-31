//----------------------------------------------//
//    Created by: Romulo do Nascimento Ferreira    //
//    Email: romulo.nf@gmail.com                    //
//----------------------------------------------//
 
// NOTICE: This code may be use dto any purpose without further
// permission from the author. You may remove this notice from the
// final code, however its appreciated if you keep the author name/email.
// Email me if theres something needing improvement
 
//set the id of the table that is gonna have the 
//moving column function in the tabelaDrag variable
document.onmouseup = soltar;
var drag = false;
 
window.onload = init
 
function init() {
tabelaDrag = document.getElementById("tabela");
linhas = tabelaDrag.getElementsByTagName("TR");
celulas = tabelaDrag.getElementsByTagName("TD");
linhaUm = tabelaDrag.rows[0]
ordenacaoMaxima = linhaUm.cells.length
 
  tabelaDrag.onselectstart = function () { return false; } 
  tabelaDrag.onmousedown = function () { return false; }
 
      for (x=0; x<celulas.length;x++) {
        arrastar(celulas[x])
        celulas[x].onmouseover = pintar
        celulas[x].onmouseout = pintar
    }
}
 
function capturarColuna(obj) {
coluna = obj.cellIndex
return coluna
}
 
function orderTd (obj) {
destino = obj.cellIndex
 
if (destino == null) return
if (coluna == destino) return
 
    for (x=0; x<linhas.length; x++) {
    tds = linhas[x].cells
    var celula = linhas[x].removeChild(tds[coluna])
        if (destino >= ordenacaoMaxima || destino + 1 >= ordenacaoMaxima) {
        linhas[x].appendChild(celula)
        }
        else {
        linhas[x].insertBefore(celula, tds[destino])
        }
    }
}
 
function soltar(e){
    if (!e) e=window.event
    if (e.target) targ = e.target
    else if (e.srcElement) targ=e.srcElement
    orderTd(targ)
    drag = false
 
    for(x=0; x<linhas.length; x++) {
        for (y=0; y<linhas[x].cells.length; y++) {
        linhas[x].cells[y].className="";
        }
    }
}
 
function arrastar(obj){
    if(!obj) return;
    obj.onmousedown = function(ev){
        colunaAtual = this.cellIndex
            for (x=0; x<linhas.length; x++) {
            linhas[x].cells[this.cellIndex].className="selecionado"
            }
        drag = true
        capturarColuna(this);
        return false;
    }
}
 
function pintar(e) {
if (!e) e=window.event
ev = e.type
 
    if (ev == "mouseover") {
        if (drag) {
            for (x=0; x<linhas.length; x++) {
                if (this.className !="selecionado") {
                linhas[x].cells[this.cellIndex].className="hover"
                }
            }
        }
    }
 
    else if (ev == "mouseout") {
        for (x=0; x<linhas.length; x++) {
            if (this.className !="selecionado") {
            linhas[x].cells[this.cellIndex].className=""
            }
        }
    }
}