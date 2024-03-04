/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ggvd.contapalavra;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class ContaBigramaMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final IntWritable ONE = new IntWritable(1);
    private final Text bigram = new Text();

    @Override
    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        StringTokenizer tokenizer = new StringTokenizer(value.toString());

        // verifica se tem mais de 2 palavras
        if (tokenizer.countTokens() >= 2) {
            String prevWord = tokenizer.nextToken();

            // tratamento do meio
            while (tokenizer.hasMoreTokens()) {
                String currentWord = tokenizer.nextToken();
                // seta o bigrama como as 2 palavras encontradas
                bigram.set(prevWord + " " + currentWord);
                context.write(bigram, ONE);
                prevWord = currentWord;
            }
        }
    }
}
