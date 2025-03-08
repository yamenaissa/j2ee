<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saisie Personne</title>
    <script type="text/javascript">
        function validateForm() {
            var nom = document.getElementById("nom").value;
            var prenom = document.getElementById("prenom").value;
            var age = document.getElementById("age").value;
            
            if (nom.trim() === "") {
                alert("Le nom est obligatoire!");
                return false;
            }
            
            if (prenom.trim() === "") {
                alert("Le prénom est obligatoire!");
                return false;
            }
            
            if (age.trim() === "" || isNaN(age) || parseInt(age) < 0) {
                alert("L'âge doit être un nombre positif!");
                return false;
            }
            
            return true;
        }
    </script>
</head>
<body>
    <h2>Saisir une nouvelle personne</h2>
    
    <form action="AjoutServlet" method="post" onsubmit="return validateForm()">
        <table>
            <tr>
                <td>Nom:</td>
                <td><input type="text" id="nom" name="nom"></td>
            </tr>
            <tr>
                <td>Prénom:</td>
                <td><input type="text" id="prenom" name="prenom"></td>
            </tr>
            <tr>
                <td>Âge:</td>
                <td><input type="text" id="age" name="age"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Ajouter"></td>
            </tr>
        </table>
    </form>
    
    <p><a href="AjoutServlet?action=afficher">Afficher la liste des personnes</a></p>
</body>
</html>