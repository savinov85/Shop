/**********После загрузки выполнить функцию отобразить всех пользователей страницы********/

$(document).ready(function () {
    showUsers();
});

/**********************Отобразить всех пользователей страницы**********************/

function showUsers() {
    $.get('/shop/user', function (data) {
        console.log(data);

        let table = "<table border='1' class=\"table\"><tr><th>ИД</th><th>Cтатус</th><th>Логин</th><th>Пароль</th><th>Роли</th><th>Удалить/забанить</th></tr>";

        for (var i = 0; i < data.length; i++) {
            table = table + "<tr>" +
                "<td>" + data[i].id + "</td>" +
                "<td>" + data[i].enabled + "</td>" +
                "<td>" + data[i].username + "</td>" +
                "<td>" + data[i].password + "</td>" +
                "<td>" + data[i].roleName + "</td>" +
                "<td>" + "<button onclick='deleteUser(" + data[i].id + ");' class='btn btn-sm btn-danger'>Delete<br>user</button>" +
                "<button onclick='deleteUser(" + data[i].id + ");' class='btn btn-sm btn-primary' >Desable<br>user</button></td>";
        }                                                                                                                                                                                        //   <a href="#" id="5" onclick="del(this.id);return false;">delete</a>
        table = table + "</tr></table>";
        $("#add_table").html(table);
    });
}
/**********************Добавить нового польователя**********************/

function send_user() {
    $.ajax({
        url: '/shop/add_user',
        dataType: 'json',
        type: 'POST',
        cache: false,
        contentType: 'application/json',
        data: JSON.stringify({
            enabled: $("#user_status").val(),
            username: $("#user_name").val(),
            password: $("#user_password").val()
        }),
        error: function (xhr, status) {
            alert(status);
        },
        success: function () {
            showUsers();
        }
    })
}
/********************** Удалить пользователя **********************/
function deleteUser(idUser) {
    $.ajax({
        url: "/shop/delete_user",
        dataType: 'json',
        type: 'POST',
        cache: false,
        contentType: 'application/json',
        data: JSON.stringify({
            id: idUser,
        }),
        error: function (xhr, status) {
            alert(status);
        },
        success: function () {
            showUsers();
        },
    });
}

