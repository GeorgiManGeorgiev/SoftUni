const Router = require('express').Router;
const productService = require('../services/productService');
const {validateProduct} = require('./helpers/productHelper');
const router = Router();

router.get('/', (req,
                         res) => {
    res.redirect('/products');
});
router.get('/products', (req,
                 res) => {
     productService.getAll(req.query)
        .then(products=>{
            res.render('home', {title: 'Browse', products});
        }).catch(() => res.status(500).end())


});
router.get('/create', (req,
                       res) => {
    res.render('create', {title: 'Create'});

});
router.post('/create', validateProduct, (req,
                                         res) => {
    productService.create(req.body)
        .then(() => res.redirect('/'))
        .catch(() => res.status(500).end())

});

router.get('/products/details/:productId',   async (req,
                                   res) => {

    let product = await productService.getOne(req.params.productId);

     res.render('details', {title: 'Product Details', product});

});




module.exports = router;