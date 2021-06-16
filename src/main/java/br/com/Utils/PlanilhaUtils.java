package br.com.Utils;

import br.com.model.Produto;
import br.com.repository.ProdutoRepository;
import br.com.service.ProdutoService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PlanilhaUtils {

    public static List<Produto> lerPlanilha() {
        List<Produto> listProduto = new ArrayList<Produto>();
        FileInputStream arquivo = null;
        try {
            arquivo = new FileInputStream(new File("C:\\Users\\gabri\\Desktop\\Nova pasta\\P2SistDis\\src\\main\\resources\\Carga_Produto.xlsx"));
            XSSFWorkbook validacaoArquivoExcel = new XSSFWorkbook(arquivo);
            XSSFSheet planilhaCargaDados = validacaoArquivoExcel.getSheetAt(0);
            Iterator<Row> rowIterator = planilhaCargaDados.iterator();

            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Produto produto = new Produto();
                listProduto.add(produto);

                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()){
                        case 0:
                            produto.set_id(cell.getRowIndex());
                            break;
                        case 1:
                            produto.setNome(cell.getStringCellValue());
                            break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listProduto;
    }


}
