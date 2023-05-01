package Actividades;

public class ListArray<T> implements TDAList <T>{
    public int size;
    public Object[] aux;

    public ListArray(int capacity){
        this.size = 0;
        this.aux = new Object[capacity];
        
    }

    public int length(){
        return size;
    }

    public boolean isEmptyList() {
        return(this.size ==0);
    }

    public void destroyList() {
        this.aux = new Object[this.aux.length];
        this.size = 0;
    }

    public int search(T x) {
        for(int i = 0; i<size;i++){
            if (this.aux[i].equals(x)){
                return i+1;
            }
        }
        return -1;
    }

    public void insertFirst(T x) {
        for(int i = this.size - 1; i >=0;i++){
            this.aux[i+1] = this.aux[i];
        }
    }

    public void insertLast(T x) {
        this.aux[this.size] = x;
        this.size ++;
    }

    public void removeNode(T x) {
        int pos = this.search(x);
        if(pos != -1){
            for(int i =pos; i<this.size-1;i++){
                this.aux[i] = this.aux[i+1];

            }
            this.aux[this.size-1] = null;
            this.size--;
        }
    }
}