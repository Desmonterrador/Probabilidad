package probabilidad;
import static java.lang.Math.log;
import javax.swing.JOptionPane;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *@author migue
 **/
public class Probabilidad {
    public static void main(String[] args) {
        int ndatos = 0;
        double amplitud;
        double rango;
        double k;
        ndatos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de datos:"));
        k = 1 + (3.322 * Math.log10(ndatos));
        int v = (int) Math.round(k);
        double Matriz [] = new double [ndatos];
        int cont1 = 0;
        for(int i = 0; i < ndatos; i++){
            double valor;
            cont1 = cont1 + 1;
            valor = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor número " + cont1 + ":"));
            Matriz[i] = valor;
        }
        Arrays.sort(Matriz);
        double v1 = Matriz[0];
        double v2 = Matriz[ndatos - 1];
        rango = v2 - v1;
        amplitud = rango / v;
        int contador = 1;
        for(double n: Matriz){
            JOptionPane.showMessageDialog(null, "El valor numero " + contador + " es: " + n);
            contador++;
        }
        JOptionPane.showMessageDialog(null, "El rango es de: " + rango);
        JOptionPane.showMessageDialog(null, "La amplitud es de: " + amplitud);
        JOptionPane.showMessageDialog(null, "El numero de clases es: " + v);
        double Li [] = new double [v];
        int con = 1;
        Li[0] = Matriz[0];
        int con1 = 1;
        //Agregar valores en arrego de Lim inf
        for(int i = 0; i < v; i++){
            JOptionPane.showMessageDialog(null, "EL limite inferior de la clase " + con + " es: " + Li[i]);
            if(con1 < v){
                Li[con1] = Li[con1 - 1] + amplitud;
                con++;
                con1++;
            }else{
                
            }
        }
        double Ls[] = new double[v];
        int con2 = 1;
        Ls[0] = Li[1];
        int con3 = 1;
        //Agregar valores en arreglo de Lim sup
        for(int i= 0; i < v; i++){
            JOptionPane.showMessageDialog(null, "El limite superior de la clase " + con2 + " es: " + Ls[i]);
            if(con3 < v){
                Ls[con3] = Ls[con3 - 1] + amplitud;
                con2++;
                con3++;
            }else{
                
            }
        }
        double fi[]  = new double[v];
        int con5 = 1;
        int con6 = 0;
        int con7 = 0;
        int con8 = ndatos;
        for(int i = 0; i < v; i++){
            con7 = 0;
            while(Matriz[con6] <= Ls[i]){
                con6++;
                con7++;
                if(con6 == con8){
                    break;
                }
                fi[i] = con7;
            }
            JOptionPane.showMessageDialog(null, "El valor de fi en la posición "+ con5 + " es: " + fi[i]);
            con5++;
            con7 = 0;
        }
        int con9 = 0;
        int con10 = 1;
        double Fi[] = new double[v];
        for(int i = 0; i < v; i++){
            if(con9 == 0){
                Fi[i] = fi[i];
                con9++;
            }else{
                Fi[i] = Fi[con9 -1] + fi[i];
                con9++;
            }
            JOptionPane.showMessageDialog(null, "el valor de Fi en la posición " + con10 + " es: " + Fi[i]);
            con10++;
        }
        double xi[] = new double[v];
        int con4 = 1;
        //Agregar valores en el arreglo de xi
        for(int i = 0; i < v; i++){
            xi[i] = (Li[i] + Ls[i]) / 2;
            JOptionPane.showMessageDialog(null, "El valor de xi en la posición " + con4 + " es: " + xi[i]);
            con4++;
        }
        double fr[] = new double[v];
        int con11 = 1;
        for(int i = 0; i < v; i++){
            fr[i] = (fi[i] * 100) / ndatos;
            JOptionPane.showMessageDialog(null, "El valor de fr en la posicion " + con11 + " es: " + fr[i] + "%");
            con11++;
        }
        double  Fr[] = new double[v];
        int con12 = 0;
        int con13 = 1;
        for(int i = 0; i < v; i++){
            if(con12 == 0){
                Fr[i] = fr[i];
                con12++;
            }else{
                Fr[i] = fr[con12 - 1] + fr[i];
                con12++;
            }
            JOptionPane.showMessageDialog(null, "El valor de Fr en la posicion " + con13 + " es: " + Fr[i] + "%");
            con13++;
        }
        double fixi[] = new double[v];
        int con14 = 1;
        for (int i = 0; i < v; i++){
            fixi[i] = fi[i] * xi[i]; 
            JOptionPane.showMessageDialog(null, "El valor de fixi en la posicion " + con14 + " es: " + fixi[i]);
            con14++;
        }
        double grados[] = new double[v];
        int con15 = 1;
        for(int i = 0; i < v; i++){
            grados[i] = (fi[i] * 360) / ndatos;
            JOptionPane.showMessageDialog(null, "El valor de grados en la posicion " + con15 + " es: " + grados[i] + "°");
            con15++;
        }
        double gradosAcum[] = new double[v];
        int con16 = 1;
        int con17 = 0;
        for(int i = 0; i < v; i++){
            if(con17 == 0){
                gradosAcum[i] = grados[i];
                con17++;
            }else{
                gradosAcum[i] = grados[con17 - 1] + grados[i];
                con17++;
            }
            JOptionPane.showMessageDialog(null, "El valor de grados acumulados en la posicion " + con16 + " es: " + gradosAcum[i] + "°");
            con16++;
        }
        System.out.println("Valores");
        for(int i = 0; i < ndatos; i++){
            System.out.println(Matriz[i]);
        }
        System.out.println("Lim inf" + "\t" + "Lim sup" + "\t" + "fi" + "\t" + "Fi" + "\t" + "xi" + "\t" + "fixi" + "\t" + "fr" + "\t" + "Fr" + "\t" + "grados" + "\t" + "grados Acum");
        for(int i = 0; i < v; i++){
            System.out.println(Li[i] + "\t" + Ls[i] + "\t" + fi[i] + "\t" + Fi[i] + "\t" + xi[i] + "\t" + fixi[i] + "\t" + fr[i] + "%" + "\t" + Fr[i] + "%" + "\t" + grados[i] + "°" + "\t" + gradosAcum[i] + "°");
        }
    }
}
