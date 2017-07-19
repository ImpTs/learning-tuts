function sumPrimes(num) {
    var primes = [];
    for (var i = 2; i <= num; i++) {
        for (var j = 2; j <= i; j++) {
            if ((i % j) === 0 && j != i) {
                break;
            }
            if (i % j === 0 && j === i) {
                primes.push(i);
            }
        }
    }
    return primes.reduce(function(a, b) {
        return a + b;
    });
}
sumPrimes(10);