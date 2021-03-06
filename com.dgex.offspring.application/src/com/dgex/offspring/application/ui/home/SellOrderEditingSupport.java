package com.dgex.offspring.application.ui.home;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import com.dgex.offspring.application.utils.ICellDataLabelProvider;
import com.dgex.offspring.providers.service.ISellOrder;

public class SellOrderEditingSupport extends EditingSupport {

  private final CellEditor editor;

  private final int columnId;

  private final ICellDataLabelProvider provider;

  public SellOrderEditingSupport(TableViewer viewer, int columnId) {
    super(viewer);
    this.editor = new TextCellEditor(viewer.getTable());
    this.provider = new SellOrderLabelProvider();
    this.columnId = columnId;
  }

  @Override
  protected CellEditor getCellEditor(Object element) {
    return editor;
  }

  @Override
  protected boolean canEdit(Object element) {
    return true;
  }

  @Override
  protected Object getValue(Object element) {
    ISellOrder t = (ISellOrder) element;
    Object[] data = { null, null, null, null };
    this.provider.getCellData(t, columnId, data);
    return data[ICellDataLabelProvider.TEXT];
  }

  @Override
  protected void setValue(Object element, Object value) {}
}