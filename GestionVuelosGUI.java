import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class GestionVuelosGUI extends JFrame {
    private ArbolBinarioBusqueda arbol;
    private Stack<Vuelo> historialDespachados;
    private Stack<Vuelo> historialCancelados;
    private JTextField horaSalidaField;
    private JComboBox<String> aerolineaComboBox;
    private JComboBox<String> destinoComboBox;
    private JTextArea resultadoArea;

    public GestionVuelosGUI() {
        arbol = new ArbolBinarioBusqueda();
        historialDespachados = new Stack<>();
        historialCancelados = new Stack<>();

        setTitle("Gestión de Vuelos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(6, 8));

        panelEntrada.add(new JLabel("Hora de Salida (HH:MM):"));
        horaSalidaField = new JTextField();
        panelEntrada.add(horaSalidaField);

        panelEntrada.add(new JLabel("Aerolínea:"));
        String[] aerolineas = {"Air Europa", "Air Berlin", "Air France", "Avianca", "Sky Airlines"};
        aerolineaComboBox = new JComboBox<>(aerolineas);
        panelEntrada.add(aerolineaComboBox);

        panelEntrada.add(new JLabel("Destino:"));
        String[] destinos = {"Bogotá", "Madrid", "Brasilia", "Denver", "Medellin", "Tokio", "París", "Londres", "Moscú", "Berlín", "Roma", "Washington DC"};
        destinoComboBox = new JComboBox<>(destinos);
        panelEntrada.add(destinoComboBox);

        JButton agregarButton = new JButton("Agregar Vuelo");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    agregarVuelo();
                }
            }
        });
        panelEntrada.add(agregarButton);

        JButton reprogramarButton = new JButton("Reprogramar");
        reprogramarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reprogramarVuelo();
            }
        });
        panelEntrada.add(reprogramarButton);

        JButton despacharButton = new JButton("Despachar Siguiente Vuelo");
        despacharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                despacharVuelo();
            }
        });
        panelEntrada.add(despacharButton);

        JButton mostrarHistorialButton = new JButton("Mostrar Historial");
        mostrarHistorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHistorial();
            }
        });
        panelEntrada.add(mostrarHistorialButton);

        JButton cancelarButton = new JButton("Cancelar Vuelo");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    cancelarVuelo();
                }
            }
        });
        panelEntrada.add(cancelarButton);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        add(panelEntrada, BorderLayout.NORTH);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);
    }

    private boolean validarCampos() {
        if (horaSalidaField.getText().isEmpty() || aerolineaComboBox.getSelectedItem() == null || destinoComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void agregarVuelo() {
        String horaSalida = horaSalidaField.getText();
        String aerolinea = (String) aerolineaComboBox.getSelectedItem();
        String destino = (String) destinoComboBox.getSelectedItem();
        Vuelo vuelo = new Vuelo(horaSalida, aerolinea, destino);
        arbol.insertar(vuelo);
        actualizarListaVuelos();
    }

    private void despacharVuelo() {
        Vuelo siguienteVuelo = arbol.encontrarMin();
        if (siguienteVuelo != null) {
            JOptionPane.showMessageDialog(this, "Despachando: " + siguienteVuelo);
            arbol.eliminarMin();
            historialDespachados.push(siguienteVuelo);
            actualizarListaVuelos();
        } else {
            JOptionPane.showMessageDialog(this, "No hay más vuelos para despachar.");
        }
    }

    private void cancelarVuelo() {
        String aerolinea = (String) aerolineaComboBox.getSelectedItem();
        Vuelo vueloCancelado = buscarVueloPorAerolinea(arbol.raiz, aerolinea);
        if (vueloCancelado != null) {
            arbol.raiz = arbol.eliminar(arbol.raiz, vueloCancelado.horaSalida);
            historialCancelados.push(vueloCancelado);
            JOptionPane.showMessageDialog(this, "Vuelo a las " + aerolinea + " cancelado.");
            actualizarListaVuelos();
        } else {
            JOptionPane.showMessageDialog(this, "Vuelo a las " + aerolinea + " no encontrado.");
        }
    }

    private Vuelo buscarVuelo(Nodo raiz, String horaSalida) {
        if (raiz == null) return null;
        if (horaSalida.equals(raiz.vuelo.horaSalida)) return raiz.vuelo;
        Vuelo vuelo = buscarVuelo(raiz.izquierda, horaSalida);
        if (vuelo != null) return vuelo;
        return buscarVuelo(raiz.derecha, horaSalida);
    }

    private Vuelo buscarVueloPorAerolinea(Nodo raiz, String aerolinea) {
        if (raiz == null) return null;
        if (aerolinea.equals(raiz.vuelo.aerolinea)) return raiz.vuelo;
        Vuelo vuelo = buscarVuelo(raiz.izquierda, aerolinea);
        if (vuelo != null) return vuelo;
        return buscarVuelo(raiz.derecha, aerolinea);
    }

    private void mostrarHistorial() {
        JTextArea historialArea = new JTextArea();
        historialArea.setEditable(false);
        historialArea.setText("Historial de Vuelos Despachados:\n");
        for (Vuelo vuelo : historialDespachados) {
            historialArea.append(vuelo + "\n");
        }
        historialArea.append("\nHistorial de Vuelos Cancelados:\n");
        for (Vuelo vuelo : historialCancelados) {
            historialArea.append(vuelo + "\n");
        }
        JOptionPane.showMessageDialog(this, new JScrollPane(historialArea), "Historial de Vuelos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void actualizarListaVuelos() {
        resultadoArea.setText("");
        arbol.inorder(resultadoArea);
    }
    private void reprogramarVuelo() {
        String aerolinea = (String) aerolineaComboBox.getSelectedItem();
        Vuelo vueloReprogramado = buscarVueloPorAerolinea(arbol.raiz, aerolinea);
        if (vueloReprogramado != null) {
            arbol.raiz = arbol.eliminar(arbol.raiz, vueloReprogramado.horaSalida);
            String nuevaHoraSalida = JOptionPane.showInputDialog(this, "Ingrese la nueva hora de salida (HH:MM):", vueloReprogramado.horaSalida);
            String[] destinos = {"Bogotá", "Madrid", "Brasilia", "Denver", "Medellin", "Tokio", "París", "Londres", "Moscú", "Berlín", "Roma", "Washington DC"};
            JComboBox<String> destinoNuevoComboBox = new JComboBox<>(destinos);
            int result = JOptionPane.showConfirmDialog(null, destinoNuevoComboBox, "Seleccione el nuevo destino", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                vueloReprogramado.destino = (String) destinoNuevoComboBox.getSelectedItem();
            }
            if (nuevaHoraSalida != null && !nuevaHoraSalida.isEmpty()) {
                vueloReprogramado.horaSalida = nuevaHoraSalida;
            }
            arbol.insertar(vueloReprogramado);
            JOptionPane.showMessageDialog(this, "Vuelo reprogramado a las " + vueloReprogramado.horaSalida + " con destino a " + vueloReprogramado.destino + " y aerolínea" + aerolinea);
            actualizarListaVuelos();
        } else {
            JOptionPane.showMessageDialog(this, "Vuelo con aerolínea " + aerolinea + " no encontrado.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionVuelosGUI().setVisible(true);
            }
        });
    }
}


