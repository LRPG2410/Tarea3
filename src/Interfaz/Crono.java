package Interfaz;

import Codigo.Tiempo;

public class Crono extends javax.swing.JFrame {

    private Tiempo hiloTiempo; // Declaración de una variable de tipo Tiempo que representa el hilo del cronómetro
    private boolean pausa; // Declaración de una variable booleana para indicar si el cronómetro está en pausa o no
    private int segundosPausados; // Declaración de una variable entera para almacenar los segundos que han transcurrido mientras el cronómetro está en pausa

    public Crono() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTiempo = new javax.swing.JLabel();
        btnComenzarPausar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTiempo.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        lblTiempo.setText("00:00");
        jPanel1.add(lblTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        btnComenzarPausar.setBackground(new java.awt.Color(204, 204, 255));
        btnComenzarPausar.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btnComenzarPausar.setText("COMENZAR");
        btnComenzarPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarPausarActionPerformed(evt);
            }
        });
        jPanel1.add(btnComenzarPausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnComenzarPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarPausarActionPerformed
        String texto = btnComenzarPausar.getText(); // Obtiene el texto del botón Comenzar/Pausar

        // Si el texto del botón es "COMENZAR" o "CONTINUAR":
        if (texto.equals("COMENZAR") || texto.equals("CONTINUAR")) {
            btnComenzarPausar.setText("PAUSAR"); // Cambia el texto del botón a "PAUSAR"

            // Si la variable pausa es verdadera (es decir, el cronómetro se ha pausado previamente):
            if (pausa) {
                hiloTiempo = new Tiempo(lblTiempo); // Crea un nuevo objeto Tiempo
                hiloTiempo.setMin(segundosPausados / 60); // Establece los minutos del cronómetro a partir de los segundos pausados
                hiloTiempo.setSeg(segundosPausados % 60); // Establece los segundos del cronómetro a partir de los segundos pausados
                pausa = false; // Establece la variable pausa a falso, indicando que el cronómetro no está pausado
            } else {
                hiloTiempo = new Tiempo(lblTiempo); // Crea un nuevo objeto Tiempo
            }

            hiloTiempo.start(); // Inicia el hilo del cronómetro
        } else { // Si el texto del botón es "PAUSAR":
            btnComenzarPausar.setText("CONTINUAR"); // Cambia el texto del botón a "CONTINUAR"
            segundosPausados = hiloTiempo.getSegundos(); // Guarda el tiempo actual del cronómetro en segundos
            hiloTiempo.pausar(); // Pausa el hilo del cronómetro
            pausa = true; // Establece la variable pausa a verdadera, indicando que el cronómetro está pausado
        }
    }//GEN-LAST:event_btnComenzarPausarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzarPausar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTiempo;
    // End of variables declaration//GEN-END:variables
}
