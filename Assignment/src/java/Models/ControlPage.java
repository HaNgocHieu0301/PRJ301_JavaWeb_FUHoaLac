/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class ControlPage {

    private int nrpp; //per page
    private int cp; //current page
    private int size;
    private int startPage;
    private int endPage;
    private int arrNrpp[] = {0, 3, 6, 9, 12};

    public ControlPage() {
    }

    public ControlPage(int nrpp, int cp, int size) {
        this.nrpp = nrpp;
        this.cp = cp;
        this.size = size;
    }

    private int tp; //...page
    private int begin;
    private int end;

    public int getNrpp() {
        return nrpp;
    }

    public void setNrpp(int nrpp) {
        this.nrpp = nrpp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void calc() {
        tp = (size + arrNrpp[nrpp] - 1) / arrNrpp[nrpp];
        cp = cp > tp ? tp - 1 : cp;
        begin = cp * arrNrpp[nrpp];
        end = begin + arrNrpp[nrpp] - 1;
        end = end > size ? size - 1 : end;
        startPage = cp - 2;
        endPage = cp + 2;
        startPage = startPage < 0 ? 0 : startPage;
        endPage = endPage >= tp ? tp - 1 : endPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int[] getArrNrpp() {
        return arrNrpp;
    }

    public void setArrNrpp(int[] arrNrpp) {
        this.arrNrpp = arrNrpp;
    }
}
