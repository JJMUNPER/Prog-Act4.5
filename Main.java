package org.losremedios.prog.ut4.actividades.act5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int x=6;
        int pos=4;
        boolean l=false;

        System.out.println("Apartado 1 Generar array aleatorio: ");
        int [] a = randomArr(10);
        int [] b = randomArr(10); // Array introducido en el apartado 1.2
        System.out.println(Arrays.toString(a));


        System.out.println("Imprimir empezando por la ultima posicion: ");
        arrayInverso(a);

        System.out.println("Ordenar el array: ");
        ordenarArray(a);

        System.out.println("Busqueda manual: ");
        System.out.println(buscaManualArray(a,x));
        System.out.println("Busqueda con binarySearch:");
        buscaConClase(a,x);

        System.out.println("Comparando arrays: ");
        comparaArrays(a);

        System.out.println("Con clone: ");
        System.out.println(Arrays.toString(usandoClone(a)));
        System.out.println("Con Arrays.copyOf: ");
        System.out.println(Arrays.toString(usandoCopyOf(a)));
        System.out.println("Con Arrays.copyOfRange: ");
        System.out.println(Arrays.toString(usandoCopyRange(a)));
        System.out.println("Con System.arraycopy: ");
        System.out.println(Arrays.toString(usandoSystemCopy(a)));

        //Actividad 5

        System.out.println("Insertar elemento: " + Arrays.toString(insertarArray(a,x,pos))+"\n");
        System.out.println("Insertar array: " + Arrays.toString(insertarArray(a,b,pos))+"\n");


        System.out.println("Elimina elemento: " + Arrays.toString(eliminaArray(a,x,l)));


        cambioParesImpares(a);
        System.out.println("Cambio Pares por Impares: " + Arrays.toString(a));





    }

    /**
     * Metodos
     * @param array
     * @return
     */


    public static int [] randomArr(int array){
        int[] arr=new int[array];
        for (int i =0;i< arr.length;i++){
            arr[i]=(int)(Math.random()*100+1);
        }
        return arr;
    }

    public static void arrayInverso(int [] array){
        for (int i= array.length-1; i>=0;i--){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void ordenarArray(int [] array){
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int buscaManualArray (int[] array, int num){

        for (int i=0;i< array.length;i++){
            if(num==array[i]){
                return i;
            }
        }
        return -1;
    }

    public static void buscaConClase (int[] array, int num){

        System.out.println(Arrays.binarySearch(array,num));
    }

    public static void comparaArrays (int[] array){
        int [] comparado = randomArr(10);
        System.out.println("Array generado para la comparación: " + Arrays.toString(comparado));
        System.out.println("Array principal para comparar: " + Arrays.toString(array));
        System.out.println(Arrays.equals(array,comparado));
    }

    public static int[] usandoClone(int [] array){
        int[]clon = array.clone();
        return clon;
    }

    public static int[] usandoCopyOf(int[]array){
        int[]copyOf=Arrays.copyOf(array,array.length);
        return copyOf;
    }

    public static int[] usandoCopyRange(int[] array){
        int[]copyRange=Arrays.copyOfRange(array,0,array.length);
        return copyRange;
    }

    public static int[] usandoSystemCopy(int[] array){
        int[]sysCopy=new int[10];
        System.arraycopy(array,0,sysCopy,0,array.length);

        return sysCopy;
    }

    //Apartado 1.1
    public static int[] insertarArray (int[] array, int elemento, int posicion){

        int [] arrayNuevo= new int [array.length+1];

        for (int i=0;i<posicion;i++){
            arrayNuevo[i]=array[i];
        }

        arrayNuevo[posicion]=elemento;

        for (int i=posicion+1;i<arrayNuevo.length;i++){
            arrayNuevo[i]=array[i-1];
        }

        return arrayNuevo;
    }

    //Apartado 1.2
    public static int[] insertarArray (int[] array1, int[] array2, int posicion){

        int[] arrayNuevo = new int [array1.length + array2.length];

        for (int i=0;i<posicion;i++){
            arrayNuevo[i]=array1[i];
        }

        for (int i=0;i<array2.length;i++){
            arrayNuevo[posicion+i] = array2[i];
        }

        for (int i=posicion+array2.length;i<arrayNuevo.length;i++){
            arrayNuevo[i]=array1[i-array2.length];
        }

        return arrayNuevo;
    }

    //Apartado 2
    public static int[] eliminaArray (int[] array, int elemento, boolean logica ){


        int index=-1;

        for (int i=0;i<array.length;i++){
            if (array[i] == elemento) {
                index=i;
                break;
            }

            if (index==0){
                return array;
            }

            if (logica){
                array[index]=0;
                return array;
            }
            else {
                int[] arrayNuevo = new int[array.length - 1];
                int j = 0;
                for (int m = 0; m < array.length; m++) {
                    if (m == index) {
                        continue;
                    }
                    arrayNuevo[j++] = array[i];
                }
                return arrayNuevo;
            }
        }
        return array;
    }

    //Apartado 3

    static void cambioParesImpares(int[] array){
          for(int i =0;i<array.length;i ++){
              if(i%2==0 && i+1<array.length){
                  int intercambiar = array[i];
                  array[i]=array[i+1];
                  array[i+1]=intercambiar;
              }
          }

    }


}
