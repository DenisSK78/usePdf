
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

<body>
<div class="head">
    <div style="background-color: #5A6693; width: 100%; color: #E9F1FF; height: 80px" >
        <h2 style="font-family: 'Amsterdam', sans-serif; font-size: 24px; padding: 20px" >English by Murphy</h2>
    </div>
</div>

<div>
    <table style="font-family: 'Amsterdam', sans-serif; font-size: small" >
        <thead>
        <tr style="color: gray">
            <th>#</th>
            <th>ID:</th>
            <th>NAME:</th>
        </tr>
        </thead>
        <tbody>
            <#list units as unit>
            <tr style="background-color: #FAFAFB">
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
    <p><img src="file:///E:/work/usepdf/src/main/resources/static/pics/megaphone.png" height="80" width="80"/></p>
    <p style="font-family: 'Amsterdam', sans-serif; font-size: small; color: grey">Repeat it at least!</p>
</div>
</body>
</html>