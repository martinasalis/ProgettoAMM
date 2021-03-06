/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amm.nerdbook;

import amm.nerdbook.Classi.post;
import amm.nerdbook.Classi.post.Type;
import amm.nerdbook.Classi.postFactory;
import amm.nerdbook.Classi.utentiReg;
import amm.nerdbook.Classi.utentiRegFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author martinasalis
 */

public class Bacheca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);
        
        
        if(session != null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true)){
            
            String user = request.getParameter("user");
            
            List<utentiReg> users = utentiRegFactory.getInstance().getUtentiList();
            session.setAttribute("users", users);
            
            int userID;

            if(user != null){
                userID = Integer.parseInt(user);
            } else {
                Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                userID = loggedUserID;
            }

            utentiReg usr = utentiRegFactory.getInstance().getUtenteById(userID);
            
            if(usr != null){
                
                request.setAttribute("urs", usr);

                List<post> posts = postFactory.getInstance().getPostList(usr);
                request.setAttribute("posts", posts);

                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                
            }else{
                
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
            
            if(request.getParameter("nuovoPost")!=null)
            {
         
                String nuovoPost = request.getParameter("nuovoPost");
                String content = request.getParameter("textPost");
                String type = request.getParameter("postType");
                String url = request.getParameter("urlImg");
                if(nuovoPost.equals("needConfirm")){
                    request.setAttribute("content", content);
                    request.setAttribute("typePost", type);
                    request.setAttribute("newpost", "true");
                    request.setAttribute("url", url);
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    return;
                }
                else{
                    post post = new post();
                    post.setContent(content);
                    post.setUrl(url);
                    if(type.equals("textType"))
                        post.setPostType(Type.IMAGE);
                    else
                        post.setPostType(Type.LINK);
                    
                    post.setUser(utentiRegFactory.getInstance()
                            .getUtenteById((Integer)session.getAttribute("loggedUserID")));
                    postFactory.getInstance().addNewPost(post);
                    request.getRequestDispatcher("Bacheca").forward(request, response);
                }
            }
            else{
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                return;
            }
            
        }   
        
        else{
            
            request.setAttribute("UserNotAuthenticated", true);
            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            
        }  
             
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
