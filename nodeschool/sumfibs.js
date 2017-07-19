function sumFibs(num) {
    var fib = [1,1];
    function fibExtend(x){
        for (i = 1; i < fib.length ; i++) {
            if ((fib[i] + fib[i-1]) <= x ){
                fib.push(fib[i] + fib[i - 1]);
            }
        }
    return fib;
    }
    fib = fibExtend(num); 
    fib = fib.filter(function(x){
       return (x % 2) === 1;     
    });
  return fib.reduce(function(x,y){
        return x + y;
  },0);
}
sumFibs(1000);