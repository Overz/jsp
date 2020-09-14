<%--
  Created by IntelliJ IDEA.
  User: cris
  Date: 31/08/2020
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/main/main.css" />
    <link rel="stylesheet" href="../css/header/header.css" />
    <link rel="stylesheet" href="../css/body/page-landing.css" />
    <link rel="stylesheet" href="../css/footer/footer.css" />
    <link rel="stylesheet" href="../css/others/form/form.css" />

    <title>Prova 01</title>
  </head>
  <body id="page-form">
    <div id="container">
      <header id="header">
        <nav id="nav-bar">
          <ul>
            <li><a href="../index.html">Home</a></li>
            <li><a href="../html/table.html">Table</a></li>
            <li><a href="./form.jsp">Form</a></li>
            <li><a href="#">Clientes</a></li>
            <li><a href="#">Contato</a></li>
          </ul>
        </nav>
        <div id="images">
          <div class="img-left-side">
            <img src=${request.contextPath}"/img/left-side.png" alt="left side" />
          </div>
          <div class="img-right-side">
            <img src="../img/right-side.png" alt="#" />
          </div>
        </div>
      </header>
      <main>
        <form id="create-class" method="post" action="${pageContext.request.contextPath}/requestMap">
          <fieldset>
            <legend class="first-legend legend-media">Seus dados</legend>

            <div class="input-block">
              <label class="label-media" for="name">Nome completo</label>
              <input name="name" id="name" required />
            </div>

            <div class="input-block">
              <label class="label-media" for="avatar">
                Link da sua foto <small>(comece com https://)</small>
              </label>
              <input type="url" id="avatar" name="avatar" />
            </div>

            <div class="input-block">
              <label class="label-media" for="whatsapp">
                Whatsapp <small>(somente números)</small>
              </label>
              <input type="number" name="whatsapp" id="whatsapp" required />
            </div>

            <div class="textarea-block">
              <label class="label-media" for="bio">Biografia</label>
              <!-- Textarea precisa ser colado, se não ele cria "espaços"
              para digitaçãoa, isso é, não começa no inicio -->
              <textarea name="bio" id="bio"></textarea>
            </div>
          </fieldset>

          <fieldset>
            <legend class="legend-media">Sobre a aula</legend>
            <div class="select-block">
              <label class="label-media" for="subject">Máteria</label>
              <select name="subject" id="subject">
                <!-- <option value="" disabled="" hidden=""> -->
                <option value="">
                  Selecione uma opção
                </option>
                <option value="1">Artes</option>
                <option value="2">Biologia</option>
                <option value="3">Ciências</option>
                <option value="4">Educação física</option>
                <option value="5">Física</option>
                <option value="6">Geografia</option>
                <option value="7">História</option>
                <option value="8">Matemática</option>
                <option value="9">Português</option>
                <option value="10">Química</option>
              </select>
            </div>

            <div class="input-block">
              <label class="label-media" for="cost">
                Custo da sua hora/aula
                <small>(R$)</small>
              </label>
              <!-- <input name="cost" id="cost" type="number" /> -->
              <input id="cost" type="number" />
            </div>
          </fieldset>

          <fieldset id="schedule-items">
            <legend class="legend-media">
              Horários disponíveis
              <button id="add-time">+ Novo Horáro</button>
            </legend>

            <div class="schedule-item">
              <div class="select-block">
                <label class="label-media" for="weekday">Dia da semana</label>
                <!-- Array de weekday, significa que para o backend,
                   pode ir mais de um valor -->
                <select name="weekday">
                  <!-- <option value="" disabled="" hidden="">
                    Selecione uma opção
                  </option> -->
                  <option value="">
                    Selecione uma opção
                  </option>
                  <option value="0">Domingo</option>
                  <option value="1">Segunda-feira</option>
                  <option value="2">Terça-feira</option>
                  <option value="3">Quarta-feira</option>
                  <option value="4">Quinta-feira</option>
                  <option value="5">Sexta-feira</option>
                  <option value="6">Sábado</option>
                </select>
              </div>

              <div class="input-block">
                <label class="label-media" for="time_from">Das</label>
                <input type="time" name="name_from" />
              </div>

              <div class="input-block">
                <label class="label-media" for="time_to">Até</label>
                <input type="time" name="time_to" />
              </div>
            </div>
          </fieldset>

          <fieldset id="schedule-items">
            <legend class="legend-media"></legend>

            <div class="schedule-item">
              <div class="select-block">
                <label class="label-media" for="weekday">Dia da semana</label>
                <select name="weekday">
                  <option value="">
                    Selecione uma opção
                  </option>
                  <option value="0">Domingo</option>
                  <option value="1">Segunda-feira</option>
                  <option value="2">Terça-feira</option>
                  <option value="3">Quarta-feira</option>
                  <option value="4">Quinta-feira</option>
                  <option value="5">Sexta-feira</option>
                  <option value="6">Sábado</option>
                </select>
              </div>

              <div class="input-block">
                <label class="label-media" for="time_from">Das</label>
                <input type="time" name="name_from" />
              </div>

              <div class="input-block">
                <label class="label-media" for="time_to">Até</label>
                <input type="time" name="time_to" />
              </div>
            </div>
          </fieldset>

          <footer class="footer-form">
            <p class="footer-media">
              <img src="../img/icons/warning.svg" alt="Aviso importante" />
              Importante!<br />
              Preencha todos os dados
            </p>
<%--            <button type="submit" form="create-class">--%>
<%--              Salvar cadastro--%>
<%--            </button>--%>
            <input type="submit" value="enviar" class="footer-form" form="create-class"/>
            <input type="reset" value="resetar" class="footer-form" form="create-class"/>
          </footer>
        </form>
      </main>
    </div>
  </body>
</html>
