package Codigo;

import javax.swing.JLabel;

public class Tiempo extends Thread { // Se define la clase tiempo, se extiende de la clase Thread y se implementa Runnable

    private JLabel lblTiempo;
    boolean pausa = false;
    int min = 00, seg = 00;

    public Tiempo(JLabel lblTiempo) { // Constructor de la clase Tiempo
        this.lblTiempo = lblTiempo;
    }

    public void setMin(int min) { // Método setMin que establece los valores de min
        this.min = min;
    }

    public void setSeg(int seg) { // Método setSeg que estable los valores de seg
        this.seg = seg;
    }

    public int getSegundos() { // Método getSegundos que retorna el tiempo en segundos que se ha contado
        return min * 60 + seg;
    }

    public void pausar() {
        pausa = true;
    }

    public void continuar() {
        pausa = false;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
                break;
            }

            if (!pausa) {
                seg++;
                if (seg > 59) {
                    min++;
                    seg = 0;
                }
                lblTiempo.setText(String.format("%02d:%02d", min, seg));
            }
        }
    }
}
