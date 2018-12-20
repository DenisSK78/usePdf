
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>English by Murphy</title>
    <style>

        @page {
            margin: 15mm 5mm 30mm 15mm;
            size: A4;
        }

        table{
            width: 100%;
            border-collapse: collapse;
        }

        td, th {
            border-bottom: 1px solid black;
            padding: 10px;
            text-align: left;
        }

        .head{
            margin-bottom: 30px;
            margin-top: 30px;
        }

    </style>
</head>
<header>
    <div class="head">
        <div>
            <h2>English by Murphy</h2>
        </div>
    </div>
</header>
<body>

<div>
    <table style="font-family: 'Amsterdam', sans-serif; font-size: small" >
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
                    <p>${unit_index + 1}</p>
                </td>

                <td>
                    <p>${unit.id}</p>
                </td>

                <td>
                    <p>${unit.name}</p>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>

<div>
    <img src="../pics/megaphone.png" height="80" width="80"/>
    <h5>Repeat it at least :)</h5>
</div>
</body>
</html>