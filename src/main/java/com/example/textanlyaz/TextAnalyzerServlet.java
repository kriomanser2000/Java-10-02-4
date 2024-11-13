package com.example.textanlyaz;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class TextAnalyzerServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String inputText = request.getParameter("text");
        if (inputText == null || inputText.trim().isEmpty())
        {
            response.getWriter().write("<h2>Enter text UA.</h2>");
            return;
        }
        String vowels = "аеєєиіїоуюяАЕЄЄИІЇОУЮЯ";
        String consonants = "бвгґдеєжзийклмнопрстуфхцчшщБВГҐДЕЄЖЗИЙКЛМНПрСТУФХЦЧШЩ";
        String punctuation = ".,!?;:";
        Set<Character> vowelsList = new HashSet<>();
        Set<Character> consonantsList = new HashSet<>();
        Set<Character> punctuationList = new HashSet<>();
        int vowelCount = 0, consonantCount = 0, punctuationCount = 0;
        for (char c : inputText.toCharArray())
        {
            if (vowels.indexOf(c) != -1)
            {
                vowelsList.add(c);
                vowelCount++;
            }
            else if (consonants.indexOf(c) != -1)
            {
                consonantsList.add(c);
                consonantCount++;
            }
            else if (punctuation.indexOf(c) != -1)
            {
                punctuationList.add(c);
                punctuationCount++;
            }
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Analyze Result: </h2>");
        out.println("<p>Number of vowels: " + vowelCount + "</p>");
        out.println("<p>Vowel list: " + vowelsList + "</p>");
        out.println("<p>Number of consonants: " + consonantCount + "</p>");
        out.println("<p>List of consonants: " + consonantsList + "</p>");
        out.println("<p>Number of punctuation marks: " + punctuationCount + "</p>");
        out.println("<p>List of punctuation marks: " + punctuationList + "</p>");
        out.println("</body></html>");
    }
}
