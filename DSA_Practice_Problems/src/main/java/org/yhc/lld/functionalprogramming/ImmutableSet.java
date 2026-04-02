package org.yhc.lld.functionalprogramming;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement an Immutable Set with following operations
 * - add(T element): returns a new ImmutableSet with the element added (if not present).
 * - contains(T element): checks if the element exists in the set.
 * - isSubsetOf(ImmutableSet<T>): returns true if the current set is a subset of another.
 */

//final class
public final class ImmutableSet<T> {

    //final state
    private final Set<T> elements;

    //Private constructor; providing static method (empty()) to instantiate
    private ImmutableSet(Set<T> elements){
        this.elements = elements;
    }

    public static <T> ImmutableSet<T> empty(){
        return new ImmutableSet<>(Collections.emptySet());
    }

    public ImmutableSet<T> add(T element){
        if(elements.contains(element)){
            return this;
        }
        Set<T> newSet = new HashSet<>(elements);
        newSet.add(element);
        return new ImmutableSet<>(Collections.unmodifiableSet(newSet));
    }

    public boolean contains(T element){
        return elements.contains(element);
    }

    public boolean isSubsetOf(ImmutableSet<T> other){
        return other.elements.containsAll(this.elements);
    }

    public static void main(String[] args) {
        ImmutableSet<String> set1 = ImmutableSet.empty();
        ImmutableSet<String> set2 = set1.add("abc");
        ImmutableSet<String> set3 = set2.add("xyz");

        System.out.println("Contains: " + set3.contains("abc"));
        System.out.println("Subset of? : "+ set2.isSubsetOf(set3));
    }
}
