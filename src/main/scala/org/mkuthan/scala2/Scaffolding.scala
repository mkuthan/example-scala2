package org.mkuthan.scala2

import cats.kernel.Monoid

object Scaffolding {
  def map[A, B](list: List[A])(fn: A => B): List[B] =
    list.foldRight(List.empty[B]) { (elem, acc) =>
      fn(elem) :: acc
    }

  def flatMap[A, B](list: List[A])(fn: A => List[B]): List[B] =
    list.foldRight(List.empty[B]) { (elem, acc) =>
      fn(elem) ::: acc
    }

  def filter[A](list: List[A])(fn: A => Boolean): List[A] =
    list.foldRight(List.empty[A]) { (elem, acc) =>
      if (fn(elem)) elem :: acc
      else acc
    }

  def sum[A](list: List[A])(implicit monoid: Monoid[A]): A =
    list.foldRight(monoid.empty)(monoid.combine)
}
