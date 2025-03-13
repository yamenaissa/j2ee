<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.Personne" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Éditer une personne</title>
    <style>
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .btn {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            margin-right: 10px;
        }
        .btn-cancel {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Éditer une personne</h1>
        
        <%
        Personne personne = (Personne) request.getAttribute("personne");
        int index = (Integer) request.getAttribute("index");
        
        if (personne != null) {
        %>
        <form action="Edit" method="post">
            <input type="hidden" name="index" value="<%= index %>">
            
            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" id="nom" name="nom" value="<%= personne.getNom() %>">
            </div>
            
            <div class="form-group">
                <label for="prenom">Prénom:</label>
                <input type="text" id="prenom" name="prenom" value="<%= personne.getPrenom() %>">
            </div>
            
            <div class="form-group">
                <label for="sexe">Sexe:</label>
                <select id="sexe" name="sexe">
                    <option value="Feminin" <%= "Feminin".equals(personne.getSexe()) ? "selected" : "" %>>Feminin</option>
                    <option value="Masculin" <%= "Masculin".equals(personne.getSexe()) ? "selected" : "" %>>Masculin</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="codePostal">Code Postal:</label>
                <input type="number" id="codePostal" name="codePostal" value="<%= personne.getCodePostal() %>">
            </div>
            
            <div class="form-group">
                <input type="submit" value="Enregistrer" class="btn">
                <a href="AjoutServlet" class="btn btn-cancel">Annuler</a>
            </div>
        </form>
        <% } else { %>
        <p>Personne non trouvée.</p>
        <a href="AjoutServlet">Retour à la liste</a>
        <% } %>
    </div>
</body>
</html>