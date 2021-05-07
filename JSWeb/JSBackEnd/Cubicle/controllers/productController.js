const Router = require('express').Router;
const productService = require('../services/productService');
const {validateProduct} = require('./helpers/productHelper');
const router = Router();

router.get('/', (req,
                 res) => {
    let products = productService.getAll(req.query);

    res.render('home', {title: 'Browse', products});
});
router.get('/create', (req,
                       res) => {
    res.render('create', {title: 'Create'});
});
router.post('/create', validateProduct, (req,
                                         res) => {
    //
    // let data = req.body;
    //
    // //Good place to validate input data
    //
    // productService.create(data,(err) => {
    //     if (err) {
    //       return res.status(500).end();
    //     }
    //     res.redirect('/');
    // });

    productService.create(req.body)
        .then(() => res.redirect('/'))
        .catch(() => res.status(500).end())
});

router.get('/details/:productId', (req,
                                   res) => {
    let product = productService.getOne(req.params.productId);
    res.render('details', {title: 'Product Details', product});
});

module.exports = router;