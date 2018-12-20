
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>English by Murphy</title>
    <style>
        html{
            font-family: Segoe UI,Frutiger,Frutiger Linotype,Dejavu Sans,Helvetica Neue,Arial,sans-serif;
        }

        .div-head{
            width: 100%;
            color: aliceblue;
            background-color: #5A6693;
            margin-bottom: 3px;
        }
        .div-name{
            width: 80%;
            margin-left: auto;
            margin-right: auto;
            padding: 10px;
        }

        .div-table{
            width: 80%;
            margin-left: auto;
            margin-right: auto;
            padding: 10px;
        }
        table{
            margin-left: auto;
            margin-right: auto;
        }
        td, th {
            border-bottom: 1px solid #ddd;
            padding: 10px;
            text-align: left;
            font-weight: 600;
        }

        th{
            color: dimgrey;
        }

        td{
            color: #00A872;
        }

        .div-picture{
            width: 80%;
            margin-left: auto;
            margin-right: auto;
            padding: 10px;
            color: dimgrey;
        }

        footer{

        }

        body{
            background-color: #E8EAEE;
        }

    </style>
</head>
<header>
    <div class="div-head">
        <div class="div-name">
            <h2>English by Murphy</h2>
        </div>
    </div>
</header>
<body>

<div class="div-table">
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>ID:</th>
            <th>NAME:</th>
        </tr>
        </thead>
        <tbody>
            <#list units as unit>
            <tr>
                <td>
                    <h3>${unit_index + 1}</h3>
                </td>

                <td>
                    <h3>${unit.id}</h3>
                </td>

                <td>
                    <h3>${unit.name}</h3>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
<div class="div-picture">

    <h5>Repeat it at least :)</h5>
</div>
</body>
</html>