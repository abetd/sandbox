function max(arg1, arg2) {
    var arg1isLarger = arg1 > arg2;
    console.log(arg1isLarger);
    if (arg1isLarger) {
        return arg1;
    } else {
        return arg2;
    }
}