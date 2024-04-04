
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RentalServiceRentalSystemManager from "./components/listers/RentalServiceRentalSystemCards"
import RentalServiceRentalSystemDetail from "./components/listers/RentalServiceRentalSystemDetail"

import ReviewServiceReviewSystemManager from "./components/listers/ReviewServiceReviewSystemCards"
import ReviewServiceReviewSystemDetail from "./components/listers/ReviewServiceReviewSystemDetail"

import BookServiceBookSystemManager from "./components/listers/BookServiceBookSystemCards"
import BookServiceBookSystemDetail from "./components/listers/BookServiceBookSystemDetail"

import PointServicePointSystemManager from "./components/listers/PointServicePointSystemCards"
import PointServicePointSystemDetail from "./components/listers/PointServicePointSystemDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/rentalServices/rentalSystems',
                name: 'RentalServiceRentalSystemManager',
                component: RentalServiceRentalSystemManager
            },
            {
                path: '/rentalServices/rentalSystems/:id',
                name: 'RentalServiceRentalSystemDetail',
                component: RentalServiceRentalSystemDetail
            },

            {
                path: '/reviewServices/reviewSystems',
                name: 'ReviewServiceReviewSystemManager',
                component: ReviewServiceReviewSystemManager
            },
            {
                path: '/reviewServices/reviewSystems/:id',
                name: 'ReviewServiceReviewSystemDetail',
                component: ReviewServiceReviewSystemDetail
            },

            {
                path: '/bookServices/bookSystems',
                name: 'BookServiceBookSystemManager',
                component: BookServiceBookSystemManager
            },
            {
                path: '/bookServices/bookSystems/:id',
                name: 'BookServiceBookSystemDetail',
                component: BookServiceBookSystemDetail
            },

            {
                path: '/pointServices/pointSystems',
                name: 'PointServicePointSystemManager',
                component: PointServicePointSystemManager
            },
            {
                path: '/pointServices/pointSystems/:id',
                name: 'PointServicePointSystemDetail',
                component: PointServicePointSystemDetail
            },




    ]
})
