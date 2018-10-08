/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.teste;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabeans.*;
import portugoloo.interpretador.Interprete;
import portugoloo.input.ScanFiles;
import portugoloo.interpretador.Compiler;



/**
 *
 * @author root
 */
public class PortugolooTeste {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {
        try { 
            testTranslate();
        } catch (Exception ex) {
            Logger.getLogger(PortugolooTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void TestWriter(){

    }

    public static void testTranslate() throws Exception{
			String path = "/home/kabessao/classes/";
			
			ScanFiles f = new ScanFiles();
			f.setPath(path);
			
			try {
					f.ScanClasses();
			} catch (IOException ex) {
					Logger.getLogger(PortugolooTeste.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			List<Arquivo> arquivos = f.getListaArquivos();
			
			List<Token> t = new TokensGenBasico().getTokens();
			
			Interprete in = new Interprete(t);
			
			in.interpretar(arquivos);

			arquivos = in.getListaJava();
			
			for (int i = 0; i < arquivos.size() ;i++) {
					for (final String linha : arquivos.get(i).getConteudoArq()){
							if (linha.contains("main")) {
								arquivos.get(i).setMain(true);
								break;
							}

					}
			}
			
			Compiler c = new Compiler(arquivos, path);
			
			for (Arquivo arquivo : arquivos) {
					for (String linha : arquivo.getConteudoArq()) {
							if (linha.indexOf("main(String[] args)") > -1){
									arquivo.setMain(true);
							}
					}
			}
			c.Compile();
			

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
