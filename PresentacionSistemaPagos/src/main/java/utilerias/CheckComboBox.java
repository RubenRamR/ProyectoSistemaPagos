package utilerias;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JList;

public class CheckComboBox<E> extends JComboBox<E> {

    private List<E> items;

    public CheckComboBox(E[] items) {
        super(items);
        this.items = new ArrayList<>();
        setRenderer(new CheckBoxCellRenderer());
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemStateChanged();
            }
        });
    }

    private void itemStateChanged() {
        E item = (E) getSelectedItem();
        if (items.contains(item)) {
            items.remove(item);
        } else {
            items.add(item);
        }
    }

    public List<E> getSelectedItems() {
        return items;
    }

    class CheckBoxCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JCheckBox checkBox = new JCheckBox(value.toString());
            checkBox.setSelected(items.contains(value));
            return checkBox;
        }
    }
}
