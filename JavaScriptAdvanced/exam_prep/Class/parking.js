class Parking {
    constructor(capacity) {
        this.capacity = capacity;
        this.vehicles = []

    }

    addCar(carModel, carNumber) {
        if (this.capacity === 0) {
            throw new Error("Not enough parking space.");
        }
        let vehicle = {
            carModel
            , carNumber
            , payed: false
        };

        this.vehicles.push(vehicle)
        this.capacity--;
        return `The ${carModel}, with a registration number ${carNumber}, parked.`
    }

    removeCar(carNumber) {
        if (!this.vehicles.find((v) => v.carNumber === carNumber)) {
            throw new Error('The car, you\'re looking for, is not found.')
        }
        let index = this.vehicles.findIndex((v) => v.carNumber === carNumber);

        if (!this.vehicles[index].payed) {
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`)
        }
        this.vehicles.splice(index, 1);
        return `${carNumber} left the parking lot.`
    }

    pay(carNumber) {
        if (!this.vehicles.find((v) => v.carNumber === carNumber)) {
            throw new Error(`${carNumber} is not in the parking lot.`)
        }
        let index = this.vehicles.findIndex((v) => v.carNumber === carNumber);
        if (this.vehicles[index].payed) {
            throw new Error(`${carNumber}'s driver has already payed his ticket."`)
        }
        this.vehicles[index].payed = true;
        return `${carNumber}'s driver successfully payed for his stay.`
    }

    getStatistics(carNumber) {
        if (!carNumber) {
            return [`The Parking Lot has ${this.capacity} empty spots left.`,
                this.vehicles.sort((a, b) => a.carModel.localeCompare(b.carModel))
                    .map((v) => `${v.carModel} == ${v.carNumber} - ${v.payed ? 'Has payed' : 'Not payed'}`).join('\n')
            ].join('\n');
        }

        let car = this.vehicles.find(car => car.carNumber === carNumber);

        return `${car.carModel} == ${car.carNumber} - ${car.payed? 'Has payed' : 'Not payed'}`

    }
}

const parking = new Parking(10);

console.log( parking.addCar('carModel', '1234'))
console.log(parking.pay('1234'))
console.log(parking.removeCar('1234'))

