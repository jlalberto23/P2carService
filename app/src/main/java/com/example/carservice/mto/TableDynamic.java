package com.example.carservice.mto;
import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class TableDynamic {
    private TableLayout tableLayout;
    private Context context;
    private String[] header;
    private ArrayList<String[]> datos;
    private TableRow row;
    private TextView txtCell;
    private int indexC, indexR;

    public TableDynamic(TableLayout tableLayout, Context context) {
        this.tableLayout = tableLayout;
        this.context = context;
    }

    public void addHeader(String[] cabeza){
        this.header = cabeza;
        createHeader();
    }

    public void addData(ArrayList<String[]> datos){
        this.datos = datos;
        createDataTable();
    }

    private void newRow(){
        row = new TableRow(context);
    }

    private void newCell(){
        txtCell = new TextView(context);
        txtCell.setGravity(Gravity.CENTER);
        txtCell.setTextSize(25);
    }

    private void createHeader(){
        indexC=0;
        newRow();
        while (indexC<header.length){
            newCell();
            txtCell.setText(header[indexC++]);
            row.addView(txtCell,newLayoutParams());
        }
        tableLayout.addView(row);
    }

    private void createDataTable(){
        String info;
        for(indexR=0;indexR<=header.length;indexR++){
            newRow();
            for (indexC=0;indexC<=header.length;indexC++){
                newCell();
                String[] rows = datos.get(indexR-1);
                info=(indexC<rows.length)?rows[indexC]:"";
                txtCell.setText(info);
                row.addView(txtCell,newLayoutParams());
            }
            tableLayout.addView(row);
        }
    }

    private TableRow.LayoutParams newLayoutParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(1,1,1,1);
        params.weight=1;
        return params;
    }
}
