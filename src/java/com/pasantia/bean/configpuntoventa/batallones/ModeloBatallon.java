/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean.configpuntoventa.batallones;

import com.pasantia.entidades.Batallon;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author root
 */
public class ModeloBatallon extends ListDataModel<Batallon> implements SelectableDataModel<Batallon> {

    public ModeloBatallon() {
    }

    public ModeloBatallon(List<Batallon> list){
        super(list);
    }
    
    
    @Override
    public Batallon getRowData(String rowKey) {
         List<Batallon> batallones = (List<Batallon>) getWrappedData();
        
        for (Batallon batallon : batallones) {
            if(batallon.getNombreBatallon().equals(rowKey))
                return batallon;
        }
        return null;
    }
    
    
    @Override
    public Object getRowKey(Batallon t) {
        return t.getNombreBatallon();
    }

    
}
