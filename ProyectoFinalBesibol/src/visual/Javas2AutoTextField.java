package visual;

import java.awt.event.ItemEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class Java2sAutoTextField extends JTextField {
	  class AutoDocument extends PlainDocument {

	    public void replace(int i, int j, String s, AttributeSet attributeset)
	        throws BadLocationException {
	      super.remove(i, j);
	      insertString(i, s, attributeset);
	    }

	    public void insertString(int i, String s, AttributeSet attributeset)
	        throws BadLocationException {
	      if (s == null || "".equals(s))
	        return;
	      String s1 = getText(0, i);
	      String s2 = getMatch(s1 + s);
	      int j = (i + s.length()) - 1;
	      if (isStrict && s2 == null) {
	        s2 = getMatch(s1);
	        j--;
	      } else if (!isStrict && s2 == null) {
	        super.insertString(i, s, attributeset);
	        return;
	      }
	      if (autoComboBox != null && s2 != null)
	        autoComboBox.setSelectedValue(s2);
	      super.remove(0, getLength());
	      super.insertString(0, s2, attributeset);
	      setSelectionStart(j + 1);
	      setSelectionEnd(getLength());
	    }

	    public void remove(int i, int j) throws BadLocationException {
	      int k = getSelectionStart();
	      if (k > 0)
	        k--;
	      String s = getMatch(getText(0, k));
	      if (!isStrict && s == null) {
	        super.remove(i, j);
	      } else {
	        super.remove(0, getLength());
	        super.insertString(0, s, null);
	      }
	      if (autoComboBox != null && s != null)
	        autoComboBox.setSelectedValue(s);
	      try {
	        setSelectionStart(k);
	        setSelectionEnd(getLength());
	      } catch (Exception exception) {
	      }
	    }

	  }

	  public Java2sAutoTextField(List list) {
	    isCaseSensitive = false;
	    isStrict = true;
	    autoComboBox = null;
	    if (list == null) {
	      throw new IllegalArgumentException("values can not be null");
	    } else {
	      dataList = list;
	      init();
	      return;
	    }
	  }

	  Java2sAutoTextField(List list, Java2sAutoComboBox b) {
	    isCaseSensitive = false;
	    isStrict = true;
	    autoComboBox = null;
	    if (list == null) {
	      throw new IllegalArgumentException("values can not be null");
	    } else {
	      dataList = list;
	      autoComboBox = b;
	      init();
	      return;
	    }
	  }

	  private void init() {
	    setDocument(new AutoDocument());
	    if (isStrict && dataList.size() > 0)
	      setText(dataList.get(0).toString());
	  }

	  private String getMatch(String s) {
	    for (int i = 0; i < dataList.size(); i++) {
	      String s1 = dataList.get(i).toString();
	      if (s1 != null) {
	        if (!isCaseSensitive && s1.toLowerCase().startsWith(s.toLowerCase()))
	          return s1;
	        if (isCaseSensitive && s1.startsWith(s))
	          return s1;
	      }
	    }

	    return null;
	  }

	  public void replaceSelection(String s) {
	    AutoDocument _lb = (AutoDocument) getDocument();
	    if (_lb != null)
	      try {
	        int i = Math.min(getCaret().getDot(), getCaret().getMark());
	        int j = Math.max(getCaret().getDot(), getCaret().getMark());
	        _lb.replace(i, j - i, s, null);
	      } catch (Exception exception) {
	      }
	  }

	  public boolean isCaseSensitive() {
	    return isCaseSensitive;
	  }

	  public void setCaseSensitive(boolean flag) {
	    isCaseSensitive = flag;
	  }

	  public boolean isStrict() {
	    return isStrict;
	  }

	  public void setStrict(boolean flag) {
	    isStrict = flag;
	  }

	  public List getDataList() {
	    return dataList;
	  }

	  public void setDataList(List list) {
	    if (list == null) {
	      throw new IllegalArgumentException("values can not be null");
	    } else {
	      dataList = list;
	      return;
	    }
	  }

	  private List dataList;

	  private boolean isCaseSensitive;

	  private boolean isStrict;

	  private Java2sAutoComboBox autoComboBox;
	}
class Java2sAutoComboBox extends JComboBox {
	  private class AutoTextFieldEditor extends BasicComboBoxEditor {

	    private Java2sAutoTextField getAutoTextFieldEditor() {
	      return (Java2sAutoTextField) editor;
	    }

	    AutoTextFieldEditor(java.util.List list) {
	      editor = new Java2sAutoTextField(list, Java2sAutoComboBox.this);
	    }
	  }

	  public Java2sAutoComboBox(java.util.List list) {
	    isFired = false;
	    autoTextFieldEditor = new AutoTextFieldEditor(list);
	    setEditable(true);
	    setModel(new DefaultComboBoxModel(list.toArray()) {

	      protected void fireContentsChanged(Object obj, int i, int j) {
	        if (!isFired)
	          super.fireContentsChanged(obj, i, j);
	      }

	    });
	    setEditor(autoTextFieldEditor);
	  }

	  public boolean isCaseSensitive() {
	    return autoTextFieldEditor.getAutoTextFieldEditor().isCaseSensitive();
	  }

	  public void setCaseSensitive(boolean flag) {
	    autoTextFieldEditor.getAutoTextFieldEditor().setCaseSensitive(flag);
	  }

	  public boolean isStrict() {
	    return autoTextFieldEditor.getAutoTextFieldEditor().isStrict();
	  }

	  public void setStrict(boolean flag) {
	    autoTextFieldEditor.getAutoTextFieldEditor().setStrict(flag);
	  }

	  public java.util.List getDataList() {
	    return autoTextFieldEditor.getAutoTextFieldEditor().getDataList();
	  }

	  public void setDataList(java.util.List list) {
	    autoTextFieldEditor.getAutoTextFieldEditor().setDataList(list);
	    setModel(new DefaultComboBoxModel(list.toArray()));
	  }

	  void setSelectedValue(Object obj) {
	    if (isFired) {
	      return;
	    } else {
	      isFired = true;
	      setSelectedItem(obj);
	      fireItemStateChanged(new ItemEvent(this, 701, selectedItemReminder, 1));
	      isFired = false;
	      return;
	    }
	  }

	  protected void fireActionEvent() {
	    if (!isFired)
	      super.fireActionEvent();
	  }

	  private AutoTextFieldEditor autoTextFieldEditor;

	  private boolean isFired;

	}