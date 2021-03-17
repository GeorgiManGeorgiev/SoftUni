function solve(arr, criterion) {
    class Ticket {
        constructor(destination, price, status) {

            this.destination = destination;
            this.price = Number(price);
            this.status = status;
        }

    }

    let tickets = [];
    for (const line of arr) {
        const tokens = line.split('|');
        let ticket = new Ticket(tokens[0], tokens[1], tokens[2]);
        tickets.push(ticket);
    }

    const sortMapper = {
        'destination':
            (a, b) => a.destination.localeCompare(b.destination),
        'price':
            (a, b) => a.price - b.destination,
        'status':
            (a, b) => a.status.localeCompare(b.status),
    }
    return tickets.sort(sortMapper[criterion]);

}


console.log(solve(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'destination'
));


console.log(solve(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'status'
));