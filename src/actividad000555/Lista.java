/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad000555;

import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SARIC
 */
public class Lista {

    Nodo cab;

    Lista() {
        cab = null;
    }

    public Nodo getBuscarporId(String id) {
        Nodo q = null;
        if (cab == null) {
            return null;
        } else {
            q = cab;
            do {
                if ((q.id).equals(id)) {
                    return q;
                } else {
                    q = q.sig;
                }
            } while (q != cab);
            return null;
        }
    }

    public Nodo getCrearNodo(JTextField JTFid,
            JTextField Jtfnom,JComboBox JCBsex,JTextField Jtfedad,JComboBox JCBgrado) {
        Nodo info = null;
        Nodo b = null;
        String id, nombre, sexo, grado;
        int edad;

        do {
            id = JTFid.getText();
            b = getBuscarporId(id);
            if (b != null) {
                JOptionPane.showMessageDialog(null, "¡Error! Este ID ya existe. Intente nuevamente.");
            }
        } while (b != null);

        nombre = Jtfnom.getText();
        sexo = JCBsex.getSelectedItem().toString();
        edad = Integer.parseInt(Jtfedad.getText());
        grado = JCBgrado.getSelectedItem().toString();

        info = new Nodo(id, nombre, sexo, edad, grado);
        return info;
    }

    public Nodo getUltimo() {
        Nodo q;
        if (cab == null) {
            return null;
        } else {
            q = cab;
            while (q.sig != cab) {
                q = q.sig;
            }
            return q;
        }
    }

    public void setAddFin(JTextField JTFid,
            JTextField Jtfnom,JComboBox JCBsex,JTextField Jtfedad,JComboBox JCBgrado) {
        Nodo info = getCrearNodo(JTFid,Jtfnom,JCBsex,Jtfedad,JCBgrado);
        Nodo q;
        if (cab == null) {
            cab = info;
            cab.sig = cab;
            JOptionPane.showMessageDialog(null,
                    "Nodo registrado.  Un elemento en la lista!");
        } else {
            q = getUltimo();
            q.sig = info;
            info.sig = cab;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado al final de la lista!");
        }
    }

    public void setAddInicio(JTextField JTFid,
            JTextField Jtfnom,JComboBox JCBsex,JTextField Jtfedad,JComboBox JCBgrado) {
        Nodo info = getCrearNodo(JTFid,Jtfnom,JCBsex,Jtfedad,JCBgrado);
        Nodo q;
        if (cab == null) {
            cab = info;
            cab.sig = cab;
            JOptionPane.showMessageDialog(null,
                    "Nodo registrado.  Un elemento en la lista!");
        } else {
            q = getUltimo();
            q.sig = info;
            info.sig = cab;
            cab = info;
            JOptionPane.showMessageDialog(null,
                    "Elemento agregado al inicio de la lista!");
        }
    }

    public Nodo getAnterior(Nodo q) {
        if ((cab == null) || (q == null)) {
            return null;
        } else {
            Nodo a = cab;
            while (a.sig != q) {
                a = a.sig;
            }
            return a;
        }
    }

    void setAddF(Nodo q) {
        if (cab == null) {
            cab = q;
        } else {
            Nodo p = getBuscarporId(q.id);
            if (p == null) {
                p = cab;
                while (p.sig != null) {
                    p = p.sig;
                }
                p.sig = q;
            }
        }
    }

    public void setEliminarPorId(String id) {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "Lista vacía!!!");
        } else {
            Nodo nodoAEliminar = getBuscarporId(id);
            Nodo anterior, ultimo;

            if (nodoAEliminar == null) {
                JOptionPane.showMessageDialog(null, "El ID no existe!!!");
            } else {

                if (cab.sig == cab && nodoAEliminar == cab) {
                    cab = null;
                    JOptionPane.showMessageDialog(null, "Eliminado. Lista vacía!!!");
                } else if (cab.sig != cab && nodoAEliminar == cab) {
                    ultimo = getUltimo();
                    cab = cab.sig;
                    ultimo.sig = cab;
                    nodoAEliminar.sig = null;
                    JOptionPane.showMessageDialog(null, "Eliminado al inicio!!!");
                } else if (nodoAEliminar.sig == cab) {
                    anterior = getAnterior(nodoAEliminar);
                    anterior.sig = cab;
                    nodoAEliminar.sig = null;
                    JOptionPane.showMessageDialog(null, "Eliminado al final!!!");
                } else {
                    anterior = getAnterior(nodoAEliminar);
                    anterior.sig = nodoAEliminar.sig;
                    nodoAEliminar.sig = null;
                    JOptionPane.showMessageDialog(null, "Eliminado entre nodos!!!");
                }

            }
        }
    }

    public void contarEstudiantesPorGrado() {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes matriculados.");
            return;
        }
        int contadorJardinNiños = 0;
        int contadorJardinNiñas = 0;
        int contadorPrejardinNiños = 0;
        int contadorPrejardinNiñas = 0;

        Nodo q = cab;
        do {

            String grado = q.getGrado();
            String sexo = q.getSexo();

            if (grado.equalsIgnoreCase("Jardín")) {
                if (sexo.equalsIgnoreCase("M")) {
                    contadorJardinNiños++;
                } else {
                    contadorJardinNiñas++;
                }
            } else if (grado.equalsIgnoreCase("Prejardín")) {
                if (sexo.equalsIgnoreCase("M")) {
                    contadorPrejardinNiños++;
                } else {
                    contadorPrejardinNiñas++;
                }
            }

            q = q.sig;
        } while (q != cab);

        String resultados = "Estudiantes matriculados:\n";
        resultados += "Jardín:\n";
        resultados += "  Niños: " + contadorJardinNiños + "\n";
        resultados += "  Niñas: " + contadorJardinNiñas + "\n";
        resultados += "Prejardín:\n";
        resultados += "  Niños: " + contadorPrejardinNiños + "\n";
        resultados += "  Niñas: " + contadorPrejardinNiñas + "\n";

        JOptionPane.showMessageDialog(null, resultados);
    }

    public void calcularPromedioEdad() {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes matriculados.");
            return;
        }

        int contNiños = 0;
        int contNiñas = 0;
        int sumaEdNiños = 0;
        int sumaEdNiñas = 0;

        Nodo q = cab;
        do {

            int edad = q.getEdad();
            String sexo = q.getSexo();

            if (sexo.equalsIgnoreCase("M")) {
                sumaEdNiños += edad;
                contNiños++;
            } else {
                sumaEdNiñas += edad;
                contNiñas++;
            }

            q = q.sig;
        } while (q != cab);

        double promedioNiños = (contNiños > 0) ? (double) sumaEdNiños / contNiños : 0;
        double promedioNiñas = (contNiñas > 0) ? (double) sumaEdNiñas / contNiñas : 0;

        String resultados = "Promedio de edad:\n";
        resultados += "Niños: " + promedioNiños + "\n";
        resultados += "Niñas: " + promedioNiñas + "\n";

        JOptionPane.showMessageDialog(null, resultados);
    }

    void setRegistrarArchivo() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        if (cab == null) {
            try {
                fichero = new FileWriter("Archivos\\prueba.txt");
                pw = new PrintWriter(fichero);
                pw.println("Lista vacia!");
                JOptionPane.showMessageDialog(
                        null, "Datos guardados al archivo!",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null, "Información: \n" + e.getMessage(),
                        "Error!",
                        JOptionPane.WARNING_MESSAGE);
            } finally {
                try {
                    //Aprovechamos el finally para 
                    //asegurarnos que se cierra el fichero.
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(
                            null, "Información: \n" + e2.getMessage(),
                            "Error!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            try {
                fichero = new FileWriter("Archivos\\prueba.txt");
                pw = new PrintWriter(fichero);
                Nodo p = cab;
                while (p != null) {
                    pw.println("" + p.getId());
                    pw.println("" + p.getNombre());
                    pw.println("" + p.getSexo());
                    pw.println("" + p.getEdad());

                    pw.println("" + p.getGrado());
                    p = p.sig;
                }
                JOptionPane.showMessageDialog(
                        null, "Datos guardados al archivo!",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null, "Información: \n" + e.getMessage(),
                        "Error!",
                        JOptionPane.WARNING_MESSAGE);
            } finally {
                try {
                    //Aprovechamos el finally para 
                    //asegurarnos que se cierra el fichero.
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(
                            null, "Información: \n" + e2.getMessage(),
                            "Error!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    //Este método obtiene información
    //de un archivo y lo carga a la lista,
    //si la información esta disponible no se
    //carga a la lista.
    void getInfoArchivo() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("Archivos\\prueba.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            int i = 0;
            Nodo q = new Nodo("", "", "", 0, "");

            while ((linea = br.readLine()) != null) {
                if (linea.equals("Lista vacia!")) {
                    JOptionPane.showMessageDialog(null, "El archivo no tiene registros!", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    switch (i) {
                        case 0:
                            q.id = linea.trim();
                            i++;
                            break;
                        case 1:
                            q.nombre = linea.trim();
                            i++;
                            break;
                        case 2:
                            q.sexo = linea.trim();
                            i++;
                            break;
                        case 3:
                            q.edad = Integer.parseInt(linea.trim());
                            i++;
                            break;
                        case 4:
                            q.grado = linea.trim();
                            setAddF(q); // Método para agregar a la lista
                            q = new Nodo("", "", "", 0, ""); // Crear un nuevo nodo
                            i = 0;
                            break;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Datos cargados del archivo!", "Información", JOptionPane.INFORMATION_MESSAGE);
            setRegistrarArchivo(); // Guardar la lista actualizada en el archivo
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Información: \n" + e.getMessage(), "Error!", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Información: \n" + e2.getMessage(), "Error!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

// Método para buscar un registro por ID en el archivo y mostrar la información completa si se encuentra
boolean buscarArchivoPorId() {
    String id=JOptionPane.showInputDialog(null,"Inserte el Id a Buscar en el archivo");
    File archivo = new File("Archivos\\prueba.txt");
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        boolean encontrado = false;
        StringBuilder registroInfo = new StringBuilder();

        while ((linea = br.readLine()) != null) {
            if (linea.equals(id)) { // Encuentra el ID buscado
                encontrado = true;
                registroInfo.append("ID: ").append(linea).append("\n");
                registroInfo.append("Nombre: ").append(br.readLine()).append("\n");
                registroInfo.append("Sexo: ").append(br.readLine()).append("\n");
                registroInfo.append("Edad: ").append(br.readLine()).append("\n");
                registroInfo.append("Grado: ").append(br.readLine()).append("\n");
                break; // Salimos del bucle una vez encontrado el registro
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, registroInfo.toString(), "Información del Registro", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Registro no encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar el registro: \n" + e.getMessage(), "Error!", JOptionPane.WARNING_MESSAGE);
        return false;
    }
}


    void eliminarRegistroPorId() {
        String id = JOptionPane.showInputDialog("Ingrese la identificación del niño:");
        File archivoOriginal = new File("Archivos\\prueba.txt");
        File archivoTemporal = new File("Archivos\\temporal.txt");
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(archivoOriginal));
            bw = new BufferedWriter(new FileWriter(archivoTemporal));

            String linea;
            boolean registroEncontrado = false;
            boolean copiarRegistro = true;

            // Lee el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                if (linea.equals(id) && copiarRegistro) { // Verifica si es el ID que queremos eliminar
                    registroEncontrado = true;
                    copiarRegistro = false;
                }

                if (copiarRegistro) {
                    bw.write(linea);
                    bw.newLine();
                }

                // Control para saltar las siguientes líneas del registro completo
                if (!copiarRegistro && linea.isEmpty()) {
                    copiarRegistro = true;
                }
            }

            if (registroEncontrado) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Registro no encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e.getMessage(), "Error!", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }

                // Elimina el archivo original y renombra el temporal
                if (archivoOriginal.delete()) {
                    archivoTemporal.renameTo(archivoOriginal);
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Error al cerrar archivos: \n" + e2.getMessage(), "Error!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
            int pFila, Nodo p) {

        miModelo.setValueAt(p.getId(), pFila, 0);
        miModelo.setValueAt(p.getNombre(), pFila, 1);
        miModelo.setValueAt(p.getSexo(), pFila, 2);
        miModelo.setValueAt(p.getEdad(), pFila, 3);
        miModelo.setValueAt(p.getGrado(), pFila, 4);

    }

    public void setLlenarJTable(JTable tab) {
        int posFilaT = 0;
        Nodo p = cab;
        DefaultTableModel miModelo = new DefaultTableModel();

        miModelo.addColumn("Id");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Sexo");
        miModelo.addColumn("Edad");
        miModelo.addColumn("Grado");

        while (p != null) {
            miModelo.addRow(new Object[]{"", "", "", "", ""});
            setRegistrarFilaJTable(miModelo, posFilaT, p);
            p = p.sig;
            posFilaT++;
        }
        tab.setModel(miModelo);
    }

}
