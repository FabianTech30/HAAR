//libreria para hacer servidores(express)
const express = require('express');
const bd = require('./bd')

const app = express();
const port = 3001;

//.use es para decir que la aplicacion acepte json
app.use(express.json());

//app es la aplicacion, .get es para obtener
app.get('/productos', (req, res) => {
    const query = 'SELECT * FROM productos';
    //bd es base de datos, all es para agregar parametros, query es el sql, [] son los parametros de la bd, fuction es para agarrar errores y filas 
    bd.all(query, [], function (err, rows) {  
        if (err) {
            res.json({error: err.message});//json es un estandar
            return
        }
        res.json(rows);
    });
})
//.post es para crear
app.post('/productos', (req, res) => {
    const query = 'INSERT INTO productos (nombre, descripcion, precio, cantidad, creado_en) VALUES (?, ?, ?, ?, ?)';
    const {nombre, descripcion, precio, cantidad} = req.body;
    if (!nombre || !descripcion || !precio || !cantidad) {
        res.json({error: 'Faltan datos'});
        return
    }
    const params = [nombre, descripcion, precio, cantidad, new Date().toDateString()];

    bd.run(query, params, function (err) {
        if (err) {
            res.json({error: err.message});
            return
        }
        res.json({id: this.lastID});
    });
})

app.get('/productos/:id', (req, res) => {
    const query = 'SELECT * FROM productos WHERE id = ?';
    const params = [req.params.id];

    bd.get(query, params, function (err, row) {
        if (err) {
            res.json({error: err.message});
            return
        }
        if (!row) {
            res.json({error: 'No encontrado'});
            return
        }
        res.json(row);
    });
})

app.listen(port, () => {
    console.log("url del servidor http://localhost:" + port);
})



const Connection = require('tedious').Connection
const Request = require('tedious').Request

const config = {
  server: 'localhost',
  authentication: {
    type: 'default',
    options: {
      userName: 'your_username', // update me
      password: 'your_password' // update me
    }
  }
}

const connection = new Connection(config)

connection.on('connect', (err) => {
  if (err) {
    console.log(err)
  } else {
    executeStatement()
  }
})
