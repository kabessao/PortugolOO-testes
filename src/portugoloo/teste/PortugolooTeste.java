/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.teste;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javabeans.Arquivo;
import portugoloo.interpretador.interprete;
import portugoloo.input.ScanFiles;


/**
 *
 * @author root
 */
public class PortugolooTeste {

    /**
     * @param args the command line arguments
     */

    public static int main(String[] args) {
	    String[] text = {
		      "||0| ||1| teste { \n"
		    , "||0| ||20| ||14| ||3|(||6|[] args) {\n"
		    , "||5|(\"isso não é um token 1 2 3 4 5 6 7 8 9 10\");\n"
		    , "}\n"
		    , "||22|"
		    , "}\n"
		    , ""
	    };
	    
	    testTranslate(text);
	    return 0;
    }
    public static void testTranslate(String[] text){
	    System.out.println(new interprete().gerarCodigo(Arrays.asList(text)));
    }


    private static void testScanfiles() {
        ScanFiles f = new ScanFiles();

        
        f.setPath("/root/classes/");
        try{
            f.ScanClasses();
        }catch (IOException e ) {
            System.out.println(e);
        }
        
        List<Arquivo> arquivos = f.getListaArquivos();
        
        for ( final Arquivo arq : arquivos){
            System.out.println("Nome do arquivo: " + arq.getNomeArq());
            System.out.println("Conteudo:");
            for ( final String linha : arq.getConteudoArq()){
                System.out.println(linha);
            }
            
        }
    }
    
    
}